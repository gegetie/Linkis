/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.impala.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-12-20")
public class TInsertResult implements org.apache.thrift.TBase<TInsertResult, TInsertResult._Fields>, java.io.Serializable, Cloneable, Comparable<TInsertResult> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TInsertResult");

  private static final org.apache.thrift.protocol.TField ROWS_APPENDED_FIELD_DESC = new org.apache.thrift.protocol.TField("rows_appended", org.apache.thrift.protocol.TType.MAP, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TInsertResultStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TInsertResultTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.Long> rows_appended; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    ROWS_APPENDED((short)1, "rows_appended");

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
        case 1: // ROWS_APPENDED
          return ROWS_APPENDED;
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
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.ROWS_APPENDED, new org.apache.thrift.meta_data.FieldMetaData("rows_appended", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I64))));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TInsertResult.class, metaDataMap);
  }

  public TInsertResult() {
  }

  public TInsertResult(
    java.util.Map<java.lang.String,java.lang.Long> rows_appended)
  {
    this();
    this.rows_appended = rows_appended;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TInsertResult(TInsertResult other) {
    if (other.isSetRows_appended()) {
      java.util.Map<java.lang.String,java.lang.Long> __this__rows_appended = new java.util.HashMap<java.lang.String,java.lang.Long>(other.rows_appended);
      this.rows_appended = __this__rows_appended;
    }
  }

  public TInsertResult deepCopy() {
    return new TInsertResult(this);
  }

  @Override
  public void clear() {
    this.rows_appended = null;
  }

  public int getRows_appendedSize() {
    return (this.rows_appended == null) ? 0 : this.rows_appended.size();
  }

  public void putToRows_appended(java.lang.String key, long val) {
    if (this.rows_appended == null) {
      this.rows_appended = new java.util.HashMap<java.lang.String,java.lang.Long>();
    }
    this.rows_appended.put(key, val);
  }

  @org.apache.thrift.annotation.Nullable
  public java.util.Map<java.lang.String,java.lang.Long> getRows_appended() {
    return this.rows_appended;
  }

  public TInsertResult setRows_appended(@org.apache.thrift.annotation.Nullable java.util.Map<java.lang.String,java.lang.Long> rows_appended) {
    this.rows_appended = rows_appended;
    return this;
  }

  public void unsetRows_appended() {
    this.rows_appended = null;
  }

  /** Returns true if field rows_appended is set (has been assigned a value) and false otherwise */
  public boolean isSetRows_appended() {
    return this.rows_appended != null;
  }

  public void setRows_appendedIsSet(boolean value) {
    if (!value) {
      this.rows_appended = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case ROWS_APPENDED:
      if (value == null) {
        unsetRows_appended();
      } else {
        setRows_appended((java.util.Map<java.lang.String,java.lang.Long>)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case ROWS_APPENDED:
      return getRows_appended();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case ROWS_APPENDED:
      return isSetRows_appended();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TInsertResult)
      return this.equals((TInsertResult)that);
    return false;
  }

  public boolean equals(TInsertResult that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_rows_appended = true && this.isSetRows_appended();
    boolean that_present_rows_appended = true && that.isSetRows_appended();
    if (this_present_rows_appended || that_present_rows_appended) {
      if (!(this_present_rows_appended && that_present_rows_appended))
        return false;
      if (!this.rows_appended.equals(that.rows_appended))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetRows_appended()) ? 131071 : 524287);
    if (isSetRows_appended())
      hashCode = hashCode * 8191 + rows_appended.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TInsertResult other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetRows_appended()).compareTo(other.isSetRows_appended());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetRows_appended()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.rows_appended, other.rows_appended);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TInsertResult(");
    boolean first = true;

    sb.append("rows_appended:");
    if (this.rows_appended == null) {
      sb.append("null");
    } else {
      sb.append(this.rows_appended);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (rows_appended == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'rows_appended' was not present! Struct: " + toString());
    }
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
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TInsertResultStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TInsertResultStandardScheme getScheme() {
      return new TInsertResultStandardScheme();
    }
  }

  private static class TInsertResultStandardScheme extends org.apache.thrift.scheme.StandardScheme<TInsertResult> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TInsertResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // ROWS_APPENDED
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map0 = iprot.readMapBegin();
                struct.rows_appended = new java.util.HashMap<java.lang.String,java.lang.Long>(2*_map0.size);
                @org.apache.thrift.annotation.Nullable java.lang.String _key1;
                long _val2;
                for (int _i3 = 0; _i3 < _map0.size; ++_i3)
                {
                  _key1 = iprot.readString();
                  _val2 = iprot.readI64();
                  struct.rows_appended.put(_key1, _val2);
                }
                iprot.readMapEnd();
              }
              struct.setRows_appendedIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TInsertResult struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.rows_appended != null) {
        oprot.writeFieldBegin(ROWS_APPENDED_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.I64, struct.rows_appended.size()));
          for (java.util.Map.Entry<java.lang.String, java.lang.Long> _iter4 : struct.rows_appended.entrySet())
          {
            oprot.writeString(_iter4.getKey());
            oprot.writeI64(_iter4.getValue());
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TInsertResultTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TInsertResultTupleScheme getScheme() {
      return new TInsertResultTupleScheme();
    }
  }

  private static class TInsertResultTupleScheme extends org.apache.thrift.scheme.TupleScheme<TInsertResult> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TInsertResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        oprot.writeI32(struct.rows_appended.size());
        for (java.util.Map.Entry<java.lang.String, java.lang.Long> _iter5 : struct.rows_appended.entrySet())
        {
          oprot.writeString(_iter5.getKey());
          oprot.writeI64(_iter5.getValue());
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TInsertResult struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TMap _map6 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.I64, iprot.readI32());
        struct.rows_appended = new java.util.HashMap<java.lang.String,java.lang.Long>(2*_map6.size);
        @org.apache.thrift.annotation.Nullable java.lang.String _key7;
        long _val8;
        for (int _i9 = 0; _i9 < _map6.size; ++_i9)
        {
          _key7 = iprot.readString();
          _val8 = iprot.readI64();
          struct.rows_appended.put(_key7, _val8);
        }
      }
      struct.setRows_appendedIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

