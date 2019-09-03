package com.webank.wedatasphere.linkis.engine.spark.utils

<<<<<<< HEAD
import java.text.NumberFormat

import com.webank.wedatasphere.linkis.common.utils.Logging
import com.webank.wedatasphere.linkis.protocol.engine.JobProgressInfo
import org.apache.commons.lang.time.DateFormatUtils
=======
import com.webank.wedatasphere.linkis.protocol.engine.JobProgressInfo
>>>>>>> 997d75d6c01b4dff87e5ac1e3a5043ed048465d5
import org.apache.spark.{JobExecutionStatus, SparkContext, SparkJobInfo}

/**
  * Created by johnnwang on 2019/5/9.
  */
<<<<<<< HEAD
object JobProgressUtil extends Logging{
=======
object JobProgressUtil {
>>>>>>> 997d75d6c01b4dff87e5ac1e3a5043ed048465d5
  def progress(sc: SparkContext, jobGroup : String):Float = {
    val jobIds = sc.statusTracker.getJobIdsForGroup(jobGroup)
    val jobs = jobIds.flatMap { id => sc.statusTracker.getJobInfo(id) }
    val stages = jobs.flatMap { job =>
      job.stageIds().flatMap(sc.statusTracker.getStageInfo)
    }

    val taskCount = stages.map(_.numTasks).sum
    val completedTaskCount = stages.map(_.numCompletedTasks).sum
    if (taskCount == 0) {
      0f
    } else {
<<<<<<< HEAD
      (completedTaskCount.toDouble / taskCount).toFloat
=======
      (100 * completedTaskCount.toDouble / taskCount).toFloat
>>>>>>> 997d75d6c01b4dff87e5ac1e3a5043ed048465d5
    }
  }

  def getActiveJobProgressInfo(sc:SparkContext,jobGroup : String):Array[JobProgressInfo] = {
    val jobIds = sc.statusTracker.getJobIdsForGroup(jobGroup)
    val activeJobs = jobIds.flatMap { id => sc.statusTracker.getJobInfo(id) }.filter(_.status() == JobExecutionStatus.RUNNING)
    val progressInfos = activeJobs.map { job =>
<<<<<<< HEAD
      val jobProgressInfo = getJobProgressInfoByStages(job, sc, jobGroup)
      val timestamp = DateFormatUtils.format(System.currentTimeMillis, "yyyy-MM-dd HH:mm:ss")
      val progress = jobProgressInfo.succeedTasks * 1d /  jobProgressInfo.totalTasks
      info(s"${jobProgressInfo.id} numTasks = ${jobProgressInfo.totalTasks}, numCompletedTasks = ${jobProgressInfo.succeedTasks}," +
        s" numActiveTasks = ${jobProgressInfo.runningTasks} , completed:${percentageFormat(progress)}")
      jobProgressInfo
=======
      getJobProgressInfoByStages(job, sc, jobGroup)
>>>>>>> 997d75d6c01b4dff87e5ac1e3a5043ed048465d5
    }
    progressInfos
  }

  def getCompletedJobProgressInfo(sc:SparkContext,jobGroup : String):Array[JobProgressInfo] = {
    val jobIds = sc.statusTracker.getJobIdsForGroup(jobGroup)
    val completedJobs = jobIds.flatMap { id => sc.statusTracker.getJobInfo(id) }.filter(_.status() == JobExecutionStatus.SUCCEEDED)
    val progressInfos = completedJobs.map { job =>
      getJobProgressInfoByStages(job, sc, jobGroup)
    }
    progressInfos
  }

  private  def getJobProgressInfoByStages(job:SparkJobInfo, sc:SparkContext, jobGroup : String) : JobProgressInfo = {
    val stages = job.stageIds().flatMap(sc.statusTracker.getStageInfo)

    var numTasks = 0
    var numActiveTasks = 0
    var numFailedTasks = 0
<<<<<<< HEAD
    var numSucceedTasks = 0
    stages.foreach{stageInfo =>
      if (stageInfo.submissionTime() > 0){
        numTasks += stageInfo.numTasks()
        numActiveTasks += stageInfo.numActiveTasks()
        numFailedTasks += stageInfo.numFailedTasks()
        numSucceedTasks += stageInfo.numCompletedTasks()
      }
    }
    JobProgressInfo(getJobId(job.jobId(), jobGroup), numTasks, numActiveTasks, numFailedTasks, numSucceedTasks)
  }

  private def getJobId( jobId : Int , jobGroup : String ): String = "jobId-" + jobId + "(" + jobGroup + ")"

  private var _percentFormat: NumberFormat = _

  def percentageFormat(decimal: Double): String = {
    if(_percentFormat == null) {
      _percentFormat = NumberFormat.getPercentInstance
      _percentFormat.setMinimumFractionDigits(2)
    }
    _percentFormat.format(decimal)
  }
=======

    stages.foreach{stageInfo =>
      numTasks += stageInfo.numTasks()
      numActiveTasks += stageInfo.numActiveTasks()
      numFailedTasks += stageInfo.numFailedTasks()
    }
    val numSucceedTasks = numTasks - numActiveTasks - numFailedTasks
    JobProgressInfo(getJobId(job.jobId(), jobGroup), numTasks, numActiveTasks, numFailedTasks, numSucceedTasks)
  }
  private def getJobId( jobId : Int , jobGroup : String ): String = "jobId-" + jobId + "(" + jobGroup + ")"
>>>>>>> 997d75d6c01b4dff87e5ac1e3a5043ed048465d5
}
