/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.impala.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-09-12")
public class TExecProgress implements org.apache.thrift.TBase<TExecProgress, TExecProgress._Fields>, java.io.Serializable, Cloneable, Comparable<TExecProgress> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TExecProgress");

  private static final org.apache.thrift.protocol.TField TOTAL_SCAN_RANGES_FIELD_DESC = new org.apache.thrift.protocol.TField("total_scan_ranges", org.apache.thrift.protocol.TType.I64, (short)1);
  private static final org.apache.thrift.protocol.TField NUM_COMPLETED_SCAN_RANGES_FIELD_DESC = new org.apache.thrift.protocol.TField("num_completed_scan_ranges", org.apache.thrift.protocol.TType.I64, (short)2);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TExecProgressStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TExecProgressTupleSchemeFactory();

  public long total_scan_ranges; // optional
  public long num_completed_scan_ranges; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    TOTAL_SCAN_RANGES((short)1, "total_scan_ranges"),
    NUM_COMPLETED_SCAN_RANGES((short)2, "num_completed_scan_ranges");

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
        case 1: // TOTAL_SCAN_RANGES
          return TOTAL_SCAN_RANGES;
        case 2: // NUM_COMPLETED_SCAN_RANGES
          return NUM_COMPLETED_SCAN_RANGES;
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
  private static final int __TOTAL_SCAN_RANGES_ISSET_ID = 0;
  private static final int __NUM_COMPLETED_SCAN_RANGES_ISSET_ID = 1;
  private byte __isset_bitfield = 0;
  private static final _Fields optionals[] = {_Fields.TOTAL_SCAN_RANGES,_Fields.NUM_COMPLETED_SCAN_RANGES};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.TOTAL_SCAN_RANGES, new org.apache.thrift.meta_data.FieldMetaData("total_scan_ranges", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    tmpMap.put(_Fields.NUM_COMPLETED_SCAN_RANGES, new org.apache.thrift.meta_data.FieldMetaData("num_completed_scan_ranges", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TExecProgress.class, metaDataMap);
  }

  public TExecProgress() {
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TExecProgress(TExecProgress other) {
    __isset_bitfield = other.__isset_bitfield;
    this.total_scan_ranges = other.total_scan_ranges;
    this.num_completed_scan_ranges = other.num_completed_scan_ranges;
  }

  public TExecProgress deepCopy() {
    return new TExecProgress(this);
  }

  @Override
  public void clear() {
    setTotal_scan_rangesIsSet(false);
    this.total_scan_ranges = 0;
    setNum_completed_scan_rangesIsSet(false);
    this.num_completed_scan_ranges = 0;
  }

  public long getTotal_scan_ranges() {
    return this.total_scan_ranges;
  }

  public TExecProgress setTotal_scan_ranges(long total_scan_ranges) {
    this.total_scan_ranges = total_scan_ranges;
    setTotal_scan_rangesIsSet(true);
    return this;
  }

  public void unsetTotal_scan_ranges() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __TOTAL_SCAN_RANGES_ISSET_ID);
  }

  /** Returns true if field total_scan_ranges is set (has been assigned a value) and false otherwise */
  public boolean isSetTotal_scan_ranges() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __TOTAL_SCAN_RANGES_ISSET_ID);
  }

  public void setTotal_scan_rangesIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __TOTAL_SCAN_RANGES_ISSET_ID, value);
  }

  public long getNum_completed_scan_ranges() {
    return this.num_completed_scan_ranges;
  }

  public TExecProgress setNum_completed_scan_ranges(long num_completed_scan_ranges) {
    this.num_completed_scan_ranges = num_completed_scan_ranges;
    setNum_completed_scan_rangesIsSet(true);
    return this;
  }

  public void unsetNum_completed_scan_ranges() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __NUM_COMPLETED_SCAN_RANGES_ISSET_ID);
  }

  /** Returns true if field num_completed_scan_ranges is set (has been assigned a value) and false otherwise */
  public boolean isSetNum_completed_scan_ranges() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __NUM_COMPLETED_SCAN_RANGES_ISSET_ID);
  }

  public void setNum_completed_scan_rangesIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __NUM_COMPLETED_SCAN_RANGES_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case TOTAL_SCAN_RANGES:
      if (value == null) {
        unsetTotal_scan_ranges();
      } else {
        setTotal_scan_ranges((java.lang.Long)value);
      }
      break;

    case NUM_COMPLETED_SCAN_RANGES:
      if (value == null) {
        unsetNum_completed_scan_ranges();
      } else {
        setNum_completed_scan_ranges((java.lang.Long)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case TOTAL_SCAN_RANGES:
      return getTotal_scan_ranges();

    case NUM_COMPLETED_SCAN_RANGES:
      return getNum_completed_scan_ranges();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case TOTAL_SCAN_RANGES:
      return isSetTotal_scan_ranges();
    case NUM_COMPLETED_SCAN_RANGES:
      return isSetNum_completed_scan_ranges();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TExecProgress)
      return this.equals((TExecProgress)that);
    return false;
  }

  public boolean equals(TExecProgress that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_total_scan_ranges = true && this.isSetTotal_scan_ranges();
    boolean that_present_total_scan_ranges = true && that.isSetTotal_scan_ranges();
    if (this_present_total_scan_ranges || that_present_total_scan_ranges) {
      if (!(this_present_total_scan_ranges && that_present_total_scan_ranges))
        return false;
      if (this.total_scan_ranges != that.total_scan_ranges)
        return false;
    }

    boolean this_present_num_completed_scan_ranges = true && this.isSetNum_completed_scan_ranges();
    boolean that_present_num_completed_scan_ranges = true && that.isSetNum_completed_scan_ranges();
    if (this_present_num_completed_scan_ranges || that_present_num_completed_scan_ranges) {
      if (!(this_present_num_completed_scan_ranges && that_present_num_completed_scan_ranges))
        return false;
      if (this.num_completed_scan_ranges != that.num_completed_scan_ranges)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetTotal_scan_ranges()) ? 131071 : 524287);
    if (isSetTotal_scan_ranges())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(total_scan_ranges);

    hashCode = hashCode * 8191 + ((isSetNum_completed_scan_ranges()) ? 131071 : 524287);
    if (isSetNum_completed_scan_ranges())
      hashCode = hashCode * 8191 + org.apache.thrift.TBaseHelper.hashCode(num_completed_scan_ranges);

    return hashCode;
  }

  @Override
  public int compareTo(TExecProgress other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetTotal_scan_ranges()).compareTo(other.isSetTotal_scan_ranges());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetTotal_scan_ranges()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.total_scan_ranges, other.total_scan_ranges);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetNum_completed_scan_ranges()).compareTo(other.isSetNum_completed_scan_ranges());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetNum_completed_scan_ranges()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.num_completed_scan_ranges, other.num_completed_scan_ranges);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TExecProgress(");
    boolean first = true;

    if (isSetTotal_scan_ranges()) {
      sb.append("total_scan_ranges:");
      sb.append(this.total_scan_ranges);
      first = false;
    }
    if (isSetNum_completed_scan_ranges()) {
      if (!first) sb.append(", ");
      sb.append("num_completed_scan_ranges:");
      sb.append(this.num_completed_scan_ranges);
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // check for sub-struct validity
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TExecProgressStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TExecProgressStandardScheme getScheme() {
      return new TExecProgressStandardScheme();
    }
  }

  private static class TExecProgressStandardScheme extends org.apache.thrift.scheme.StandardScheme<TExecProgress> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TExecProgress struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // TOTAL_SCAN_RANGES
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.total_scan_ranges = iprot.readI64();
              struct.setTotal_scan_rangesIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // NUM_COMPLETED_SCAN_RANGES
            if (schemeField.type == org.apache.thrift.protocol.TType.I64) {
              struct.num_completed_scan_ranges = iprot.readI64();
              struct.setNum_completed_scan_rangesIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TExecProgress struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.isSetTotal_scan_ranges()) {
        oprot.writeFieldBegin(TOTAL_SCAN_RANGES_FIELD_DESC);
        oprot.writeI64(struct.total_scan_ranges);
        oprot.writeFieldEnd();
      }
      if (struct.isSetNum_completed_scan_ranges()) {
        oprot.writeFieldBegin(NUM_COMPLETED_SCAN_RANGES_FIELD_DESC);
        oprot.writeI64(struct.num_completed_scan_ranges);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TExecProgressTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TExecProgressTupleScheme getScheme() {
      return new TExecProgressTupleScheme();
    }
  }

  private static class TExecProgressTupleScheme extends org.apache.thrift.scheme.TupleScheme<TExecProgress> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TExecProgress struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetTotal_scan_ranges()) {
        optionals.set(0);
      }
      if (struct.isSetNum_completed_scan_ranges()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetTotal_scan_ranges()) {
        oprot.writeI64(struct.total_scan_ranges);
      }
      if (struct.isSetNum_completed_scan_ranges()) {
        oprot.writeI64(struct.num_completed_scan_ranges);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TExecProgress struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.total_scan_ranges = iprot.readI64();
        struct.setTotal_scan_rangesIsSet(true);
      }
      if (incoming.get(1)) {
        struct.num_completed_scan_ranges = iprot.readI64();
        struct.setNum_completed_scan_rangesIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

