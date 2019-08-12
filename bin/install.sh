#!/bin/sh

shellDir=`dirname $0`
workDir=`cd ${shellDir}/..;pwd`



#To be compatible with MacOS and Linux
txt=""
if [[ "$OSTYPE" == "darwin"* ]]; then
    txt="''"
elif [[ "$OSTYPE" == "linux-gnu" ]]; then
    # linux
    txt=""
elif [[ "$OSTYPE" == "cygwin" ]]; then
    echo "linkis not support Windows operating system"
    exit 1
elif [[ "$OSTYPE" == "msys" ]]; then
    echo "linkis not support Windows operating system"
    exit 1
elif [[ "$OSTYPE" == "win32" ]]; then
    echo "linkis not support Windows operating system"
    exit 1
elif [[ "$OSTYPE" == "freebsd"* ]]; then

    txt=""
else
    echo "Operating system unknown, please tell us(submit issue) for better service"
    exit 1
fi

function isSuccess(){
if [ $? -ne 0 ]; then
    echo "Failed to " + $1
    exit 1
else
    echo "Succeed to" + $1
fi
}
##install env:expect,
sudo yum install -y expect
isSuccess "install expect"

##load config
echo "step1:load config "
source ${workDir}/conf/config.sh
source ${workDir}/conf/db.sh
isSuccess "load config"

local_host="`hostname --fqdn`"

##stop server
echo "step2,stop server"
sh ${workDir}/bin/stop-all.sh

##Eurkea install
SERVERNAME=eureka
SERVER_IP=$EUREKA_INSTALL_IP
SERVER_PORT=$EUREKA_PORT
SERVER_HOME=$LINKIS_INSTALL_HOME
echo "$SERVERNAME-step1: create dir"
if test -z "$SERVER_IP"
then
  SERVER_IP=$local_host
fi
EUREKA_URL=http://$SERVER_IP:$EUREKA_PORT/eureka/
if ! ssh $SERVER_IP test -e $SERVER_HOME; then
  ssh $SERVER_IP "sudo mkdir -p $SERVER_HOME;sudo chown -R $deployUser:$deployUser $SERVER_HOME"
  isSuccess "create the dir of $SERVER_HOME"
fi

echo "$SERVERNAME-step2:copy install package"
scp ${workDir}/share/springcloud/$SERVERNAME/$SERVERNAME.zip $SERVER_IP:$SERVER_HOME
isSuccess "copy $SERVERNAME"
ssh $SERVER_IP "cd $SERVER_HOME/;rm -rf eureka;unzip  $SERVERNAME.zip > /dev/null"

echo "$SERVERNAME-step3:subsitution conf"
eureka_conf_path=$SERVER_HOME/$SERVERNAME/conf/application-$SERVERNAME.yml
ssh $SERVER_IP "sed -i  \"s#port:.*#port: $SERVER_PORT#g\" $eureka_conf_path"
ssh $SERVER_IP "sed -i  \"s#defaultZone:.*#defaultZone: $EUREKA_URL#g\" $eureka_conf_path"
ssh $SERVER_IP "sed -i  \"s#hostname:.*#hostname: $SERVER_IP#g\" $eureka_conf_path"
isSuccess "subsitution conf of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"
##Eurkea install  end



##function
function installPackage(){
echo "$SERVERNAME-step1: create dir"
if test -z "$SERVER_IP"
then
  SERVER_IP=$local_host
fi

if ! ssh $SERVER_IP test -e $SERVER_HOME; then
  ssh $SERVER_IP "sudo mkdir -p $SERVER_HOME;sudo chown -R $deployUser:$deployUser $SERVER_HOME"
  isSuccess "create the dir of  $SERVERNAME"
fi

echo "$SERVERNAME-step2:copy install package"
scp ${workDir}/share/$PACKAGE_DIR/$SERVERNAME.zip $SERVER_IP:$SERVER_HOME
isSuccess "copy  ${SERVERNAME}.zip"
ssh $SERVER_IP "cd $SERVER_HOME/;rm -rf $SERVERNAME-bak; mv -f $SERVERNAME $SERVERNAME-bak"
ssh $SERVER_IP "cd $SERVER_HOME/;unzip $SERVERNAME.zip > /dev/null"
isSuccess "unzip  ${SERVERNAME}.zip"
if [ "$SERVERNAME" != "linkis-gateway" ]
then
    scp ${workDir}/share/linkis/module/module.zip $SERVER_IP:$SERVER_HOME
    isSuccess "cp module.zip"
    ssh $SERVER_IP "cd $SERVER_HOME/;rm -rf modulebak;mv -f module modulebak;"
    ssh $SERVER_IP "cd $SERVER_HOME/;unzip  module.zip > /dev/null;cp module/lib/* $SERVER_HOME/$SERVERNAME/lib/"
    isSuccess "unzip module.zip"
fi
echo "$SERVERNAME-step3:subsitution conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/application.yml
ssh $SERVER_IP "sed -i  \"s#port:.*#port: $SERVER_PORT#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#defaultZone:.*#defaultZone: $EUREKA_URL#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#hostname:.*#hostname: $SERVER_IP#g\" $SERVER_CONF_PATH"
isSuccess "subsitution conf of $SERVERNAME"
}
##function end

##GateWay Install
PACKAGE_DIR=springcloud/gateway
SERVERNAME=linkis-gateway
SERVER_IP=$GATEWAY_INSTALL_IP
SERVER_PORT=$GATEWAY_PORT
SERVER_HOME=$LINKIS_INSTALL_HOME
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.ldap.proxy.url.*#wds.linkis.ldap.proxy.url=$LDAP_URL#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.ldap.proxy.baseDN.*#wds.linkis.ldap.proxy.baseDN=$LDAP_BASEDN#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.gateway.admin.user.*#wds.linkis.gateway.admin.user=$deployUser#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"
##GateWay Install end

##publicservice install
PACKAGE_DIR=linkis/linkis-publicservice
SERVERNAME=linkis-publicservice
SERVER_IP=$PUBLICSERVICE_INSTALL_IP
SERVER_PORT=$PUBLICSERVICE_PORT
SERVER_HOME=$LINKIS_INSTALL_HOME
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.server.mybatis.datasource.url.*#wds.linkis.server.mybatis.datasource.url=jdbc:mysql://${MYSQL_HOST}:${MYSQL_PORT}/${MYSQL_DB}?characterEncoding=UTF-8#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.server.mybatis.datasource.username.*#wds.linkis.server.mybatis.datasource.username=$MYSQL_USER#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.server.mybatis.datasource.password.*#wds.linkis.server.mybatis.datasource.password=$MYSQL_PASSWORD#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.workspace.filesystem.localuserrootpath.*#wds.linkis.workspace.filesystem.localuserrootpath=$WORKSPACE_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.workspace.filesystem.hdfsuserrootpath.prefix.*#wds.linkis.workspace.filesystem.hdfsuserrootpath.prefix=$HDFS_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"
##publicservice end


##linkis-database install
PACKAGE_DIR=linkis/linkis-database
SERVERNAME=linkis-database
SERVER_IP=$DATABASE_INSTALL_IP
SERVER_PORT=$DATABASE_PORT
SERVER_HOME=$LINKIS_INSTALL_HOME
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.server.mybatis.datasource.url.*#wds.linkis.server.mybatis.datasource.url=jdbc:mysql://${MYSQL_HOST}:${MYSQL_PORT}/${MYSQL_DB}?characterEncoding=UTF-8#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.server.mybatis.datasource.username.*#wds.linkis.server.mybatis.datasource.username=$MYSQL_USER#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.server.mybatis.datasource.password.*#wds.linkis.server.mybatis.datasource.password=$MYSQL_PASSWORD#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"
##database end


##ResourceManager install
PACKAGE_DIR=linkis/rm
SERVERNAME=linkis-resourcemanager
SERVER_IP=$RESOURCEMANAGER_INSTALL_IP
SERVER_PORT=$RESOURCEMANAGER_PORT
SERVER_HOME=$LINKIS_INSTALL_HOME
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.server.mybatis.datasource.url.*#wds.linkis.server.mybatis.datasource.url=jdbc:mysql://${MYSQL_HOST}:${MYSQL_PORT}/${MYSQL_DB}?characterEncoding=UTF-8#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.server.mybatis.datasource.username.*#wds.linkis.server.mybatis.datasource.username=$MYSQL_USER#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.server.mybatis.datasource.password.*#wds.linkis.server.mybatis.datasource.password=$MYSQL_PASSWORD#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "rm $SERVER_HOME/$SERVERNAME/lib/json4s-*3.5.3.jar"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"
##ResourceManager install end

##SparkEM install
PACKAGE_DIR=linkis/ujes/spark
SERVERNAME=linkis-ujes-spark-enginemanager
SERVER_IP=$SPARK_INSTALL_IP
SERVER_PORT=$SPARK_EM_PORT
SERVER_HOME=$LINKIS_INSTALL_HOME
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ENGINE_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis-engine.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.enginemanager.sudo.script.*#wds.linkis.enginemanager.sudo.script=$SERVER_HOME/$SERVERNAME/bin/rootScript.sh#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.enginemanager.core.jar.*#wds.linkis.enginemanager.core.jar=$SERVER_HOME/$SERVERNAME/lib/linkis-ujes-spark-engine-$LINKIS_VERSION.jar#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.spark.driver.conf.mainjar.*#wds.linkis.spark.driver.conf.mainjar=$SERVER_HOME/$SERVERNAME/conf:$SERVER_HOME/$SERVERNAME/lib/*#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"
##SparkEM install end

##SparkEntrance install
PACKAGE_DIR=linkis/ujes/spark
SERVERNAME=linkis-ujes-spark-entrance
SERVER_PORT=$SPARK_ENTRANCE_PORT
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.entrance.config.logPath.*#wds.linkis.entrance.config.logPath=$WORKSPACE_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.resultSet.store.path.*#wds.linkis.resultSet.store.path=$HDFS_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"
##SparkEntrance install end

##HiveEM install
PACKAGE_DIR=linkis/ujes/hive
SERVERNAME=linkis-ujes-hive-enginemanager
SERVER_IP=$HIVE_INSTALL_IP
SERVER_PORT=$HIVE_EM_PORT
SERVER_HOME=$LINKIS_INSTALL_HOME
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.enginemanager.sudo.script.*#wds.linkis.enginemanager.sudo.script=$SERVER_HOME/$SERVERNAME/bin/rootScript.sh#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
ssh $SERVER_IP "rm $SERVER_HOME/$SERVERNAME/lib/servlet-api-2.5.jar"
echo "<----------------$SERVERNAME:end------------------->"
##HiveEM install end

##HiveEntrance install
PACKAGE_DIR=linkis/ujes/hive
SERVERNAME=linkis-ujes-hive-entrance
SERVER_PORT=$HIVE_ENTRANCE_PORT
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.entrance.config.logPath.*#wds.linkis.entrance.config.logPath=$WORKSPACE_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.resultSet.store.path.*#wds.linkis.resultSet.store.path=$HDFS_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"
##HiveEntrance install end



##PythonEM install
PACKAGE_DIR=linkis/ujes/python
SERVERNAME=linkis-ujes-python-enginemanager
SERVER_IP=$PYTHON_INSTALL_IP
SERVER_PORT=$PYTHON_EM_PORT
SERVER_HOME=$LINKIS_INSTALL_HOME
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.enginemanager.sudo.script.*#wds.linkis.enginemanager.sudo.script=$SERVER_HOME/$SERVERNAME/bin/rootScript.sh#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"


##PythonEntrance install
PACKAGE_DIR=linkis/ujes/python
SERVERNAME=linkis-ujes-python-entrance
SERVER_PORT=$PYTHON_ENTRANCE_PORT
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.entrance.config.logPath.*#wds.linkis.entrance.config.logPath=$WORKSPACE_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.resultSet.store.path.*#wds.linkis.resultSet.store.path=$HDFS_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"
##PythonEntrance install end

##pipelineEM install
PACKAGE_DIR=linkis/ujes/pipeline
SERVERNAME=linkis-ujes-pipeline-enginemanager
SERVER_IP=$PIPELINE_INSTALL_IP
SERVER_PORT=$PIPELINE_EM_PORT
SERVER_HOME=$LINKIS_INSTALL_HOME
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.enginemanager.sudo.script.*#wds.linkis.enginemanager.sudo.script=$SERVER_HOME/$SERVERNAME/bin/rootScript.sh#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"


##pipelineEntrance install
PACKAGE_DIR=linkis/ujes/pipeline
SERVERNAME=linkis-ujes-pipeline-entrance
SERVER_PORT=$PIPELINE_ENTRANCE_PORT
###install dir
installPackage
###update linkis.properties
echo "$SERVERNAME-step4:update linkis conf"
SERVER_CONF_PATH=$SERVER_HOME/$SERVERNAME/conf/linkis.properties
ssh $SERVER_IP "sed -i  \"s#wds.linkis.entrance.config.logPath.*#wds.linkis.entrance.config.logPath=$WORKSPACE_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
ssh $SERVER_IP "sed -i  \"s#wds.linkis.resultSet.store.path.*#wds.linkis.resultSet.store.path=$HDFS_USER_ROOT_PATH#g\" $SERVER_CONF_PATH"
isSuccess "subsitution linkis.properties of $SERVERNAME"
echo "<----------------$SERVERNAME:end------------------->"








##init db
#mysql -h$MYSQL_HOST -P$MYSQL_PORT -u$MYSQL_USER -p$MYSQL_PASSWORD -D$MYSQL_DB -e "source ${workDir}/db/linkis_ddl.sql"
#isSuccess "source linkis_ddl.sql"
#mysql -h$MYSQL_HOST -P$MYSQL_PORT -u$MYSQL_USER -p$MYSQL_PASSWORD -D$MYSQL_DB -e "source ${workDir}/db/linkis_dml.sql"
#isSuccess "source linkis_dml.sql"
