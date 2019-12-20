/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.impala.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-12-20")
public class TGetExecSummaryResp implements org.apache.thrift.TBase<TGetExecSummaryResp, TGetExecSummaryResp._Fields>, java.io.Serializable, Cloneable, Comparable<TGetExecSummaryResp> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TGetExecSummaryResp");

  private static final org.apache.thrift.protocol.TField STATUS_FIELD_DESC = new org.apache.thrift.protocol.TField("status", org.apache.thrift.protocol.TType.STRUCT, (short)1);
  private static final org.apache.thrift.protocol.TField SUMMARY_FIELD_DESC = new org.apache.thrift.protocol.TField("summary", org.apache.thrift.protocol.TType.STRUCT, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TGetExecSummaryRespStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TGetExecSummaryRespTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable org.apache.hive.service.cli.thrift.TStatus status; // required
  public @org.apache.thrift.annotation.Nullable org.apache.impala.thrift.TExecSummary summary; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    STATUS((short)1, "status"),
    SUMMARY((short)2, "summary");

    private static final java.util.Map<java.lang.String, _Fields> byName = new java.util.HashMap<java.lang.String, _Fields>();

    static {
      for (_Fields field : java.util.EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // STATUS
          return STATUS;
        case 2: // SUMMARY
          return SUMMARY;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new java.lang.IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    @org.apache.thrift.annotation.Nullable
    public static _Fields findByName(java.lang.String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final java.lang.String _fieldName;

    _Fields(short thriftId, java.lang.String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public java.lang.String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  private static final _Fields optionals[] = {_Fields.SUMMARY};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.STATUS, new org.apache.thrift.meta_data.FieldMetaData("status", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, org.apache.hive.service.cli.thrift.TStatus.class)));
    tmpMap.put(_Fields.SUMMARY, new org.apache.thrift.meta_data.FieldMetaData("summary", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, org.apache.impala.thrift.TExecSummary.class)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TGetExecSummaryResp.class, metaDataMap);
  }

  public TGetExecSummaryResp() {
  }

  public TGetExecSummaryResp(
    org.apache.hive.service.cli.thrift.TStatus status)
  {
    this();
    this.status = status;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TGetExecSummaryResp(TGetExecSummaryResp other) {
    if (other.isSetStatus()) {
      this.status = new org.apache.hive.service.cli.thrift.TStatus(other.status);
    }
    if (other.isSetSummary()) {
      this.summary = new org.apache.impala.thrift.TExecSummary(other.summary);
    }
  }

  public TGetExecSummaryResp deepCopy() {
    return new TGetExecSummaryResp(this);
  }

  @Override
  public void clear() {
    this.status = null;
    this.summary = null;
  }

  @org.apache.thrift.annotation.Nullable
  public org.apache.hive.service.cli.thrift.TStatus getStatus() {
    return this.status;
  }

  public TGetExecSummaryResp setStatus(@org.apache.thrift.annotation.Nullable org.apache.hive.service.cli.thrift.TStatus status) {
    this.status = status;
    return this;
  }

  public void unsetStatus() {
    this.status = null;
  }

  /** Returns true if field status is set (has been assigned a value) and false otherwise */
  public boolean isSetStatus() {
    return this.status != null;
  }

  public void setStatusIsSet(boolean value) {
    if (!value) {
      this.status = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public org.apache.impala.thrift.TExecSummary getSummary() {
    return this.summary;
  }

  public TGetExecSummaryResp setSummary(@org.apache.thrift.annotation.Nullable org.apache.impala.thrift.TExecSummary summary) {
    this.summary = summary;
    return this;
  }

  public void unsetSummary() {
    this.summary = null;
  }

  /** Returns true if field summary is set (has been assigned a value) and false otherwise */
  public boolean isSetSummary() {
    return this.summary != null;
  }

  public void setSummaryIsSet(boolean value) {
    if (!value) {
      this.summary = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case STATUS:
      if (value == null) {
        unsetStatus();
      } else {
        setStatus((org.apache.hive.service.cli.thrift.TStatus)value);
      }
      break;

    case SUMMARY:
      if (value == null) {
        unsetSummary();
      } else {
        setSummary((org.apache.impala.thrift.TExecSummary)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case STATUS:
      return getStatus();

    case SUMMARY:
      return getSummary();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case STATUS:
      return isSetStatus();
    case SUMMARY:
      return isSetSummary();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TGetExecSummaryResp)
      return this.equals((TGetExecSummaryResp)that);
    return false;
  }

  public boolean equals(TGetExecSummaryResp that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_status = true && this.isSetStatus();
    boolean that_present_status = true && that.isSetStatus();
    if (this_present_status || that_present_status) {
      if (!(this_present_status && that_present_status))
        return false;
      if (!this.status.equals(that.status))
        return false;
    }

    boolean this_present_summary = true && this.isSetSummary();
    boolean that_present_summary = true && that.isSetSummary();
    if (this_present_summary || that_present_summary) {
      if (!(this_present_summary && that_present_summary))
        return false;
      if (!this.summary.equals(that.summary))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetStatus()) ? 131071 : 524287);
    if (isSetStatus())
      hashCode = hashCode * 8191 + status.hashCode();

    hashCode = hashCode * 8191 + ((isSetSummary()) ? 131071 : 524287);
    if (isSetSummary())
      hashCode = hashCode * 8191 + summary.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TGetExecSummaryResp other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetStatus()).compareTo(other.isSetStatus());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetStatus()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.status, other.status);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetSummary()).compareTo(other.isSetSummary());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSummary()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.summary, other.summary);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  @org.apache.thrift.annotation.Nullable
  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    scheme(iprot).read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    scheme(oprot).write(oprot, this);
  }

  @Override
  public java.lang.String toString() {
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TGetExecSummaryResp(");
    boolean first = true;

    sb.append("status:");
    if (this.status == null) {
      sb.append("null");
    } else {
      sb.append(this.status);
    }
    first = false;
    if (isSetSummary()) {
      if (!first) sb.append(", ");
      sb.append("summary:");
      if (this.summary == null) {
        sb.append("null");
      } else {
        sb.append(this.summary);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (status == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'status' was not present! Struct: " + toString());
    }
    // check for sub-struct validity
    if (status != null) {
      status.validate();
    }
    if (summary != null) {
      summary.validate();
    }
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, java.lang.ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TGetExecSummaryRespStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TGetExecSummaryRespStandardScheme getScheme() {
      return new TGetExecSummaryRespStandardScheme();
    }
  }

  private static class TGetExecSummaryRespStandardScheme extends org.apache.thrift.scheme.StandardScheme<TGetExecSummaryResp> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TGetExecSummaryResp struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // STATUS
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.status = new org.apache.hive.service.cli.thrift.TStatus();
              struct.status.read(iprot);
              struct.setStatusIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // SUMMARY
            if (schemeField.type == org.apache.thrift.protocol.TType.STRUCT) {
              struct.summary = new org.apache.impala.thrift.TExecSummary();
              struct.summary.read(iprot);
              struct.setSummaryIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();

      // check for required fields of primitive type, which can't be checked in the validate method
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TGetExecSummaryResp struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.status != null) {
        oprot.writeFieldBegin(STATUS_FIELD_DESC);
        struct.status.write(oprot);
        oprot.writeFieldEnd();
      }
      if (struct.summary != null) {
        if (struct.isSetSummary()) {
          oprot.writeFieldBegin(SUMMARY_FIELD_DESC);
          struct.summary.write(oprot);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TGetExecSummaryRespTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TGetExecSummaryRespTupleScheme getScheme() {
      return new TGetExecSummaryRespTupleScheme();
    }
  }

  private static class TGetExecSummaryRespTupleScheme extends org.apache.thrift.scheme.TupleScheme<TGetExecSummaryResp> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TGetExecSummaryResp struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.status.write(oprot);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetSummary()) {
        optionals.set(0);
      }
      oprot.writeBitSet(optionals, 1);
      if (struct.isSetSummary()) {
        struct.summary.write(oprot);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TGetExecSummaryResp struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.status = new org.apache.hive.service.cli.thrift.TStatus();
      struct.status.read(iprot);
      struct.setStatusIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(1);
      if (incoming.get(0)) {
        struct.summary = new org.apache.impala.thrift.TExecSummary();
        struct.summary.read(iprot);
        struct.setSummaryIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

