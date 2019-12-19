/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.hive.service.cli.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-12-18")
public class TArrayTypeEntry implements org.apache.thrift.TBase<TArrayTypeEntry, TArrayTypeEntry._Fields>, java.io.Serializable, Cloneable, Comparable<TArrayTypeEntry> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TArrayTypeEntry");

  private static final org.apache.thrift.protocol.TField OBJECT_TYPE_PTR_FIELD_DESC = new org.apache.thrift.protocol.TField("objectTypePtr", org.apache.thrift.protocol.TType.I32, (short)1);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TArrayTypeEntryStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TArrayTypeEntryTupleSchemeFactory();

  public int objectTypePtr; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    OBJECT_TYPE_PTR((short)1, "objectTypePtr");

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
        case 1: // OBJECT_TYPE_PTR
          return OBJECT_TYPE_PTR;
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
  private static final int __OBJECTTYPEPTR_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.OBJECT_TYPE_PTR, new org.apache.thrift.meta_data.FieldMetaData("objectTypePtr", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32        , "TTypeEntryPtr")));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TArrayTypeEntry.class, metaDataMap);
  }

  public TArrayTypeEntry() {
  }

  public TArrayTypeEntry(
    int objectTypePtr)
  {
    this();
    this.objectTypePtr = objectTypePtr;
    setObjectTypePtrIsSet(true);
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TArrayTypeEntry(TArrayTypeEntry other) {
    __isset_bitfield = other.__isset_bitfield;
    this.objectTypePtr = other.objectTypePtr;
  }

  public TArrayTypeEntry deepCopy() {
    return new TArrayTypeEntry(this);
  }

  @Override
  public void clear() {
    setObjectTypePtrIsSet(false);
    this.objectTypePtr = 0;
  }

  public int getObjectTypePtr() {
    return this.objectTypePtr;
  }

  public TArrayTypeEntry setObjectTypePtr(int objectTypePtr) {
    this.objectTypePtr = objectTypePtr;
    setObjectTypePtrIsSet(true);
    return this;
  }

  public void unsetObjectTypePtr() {
    __isset_bitfield = org.apache.thrift.EncodingUtils.clearBit(__isset_bitfield, __OBJECTTYPEPTR_ISSET_ID);
  }

  /** Returns true if field objectTypePtr is set (has been assigned a value) and false otherwise */
  public boolean isSetObjectTypePtr() {
    return org.apache.thrift.EncodingUtils.testBit(__isset_bitfield, __OBJECTTYPEPTR_ISSET_ID);
  }

  public void setObjectTypePtrIsSet(boolean value) {
    __isset_bitfield = org.apache.thrift.EncodingUtils.setBit(__isset_bitfield, __OBJECTTYPEPTR_ISSET_ID, value);
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case OBJECT_TYPE_PTR:
      if (value == null) {
        unsetObjectTypePtr();
      } else {
        setObjectTypePtr((java.lang.Integer)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case OBJECT_TYPE_PTR:
      return getObjectTypePtr();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case OBJECT_TYPE_PTR:
      return isSetObjectTypePtr();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TArrayTypeEntry)
      return this.equals((TArrayTypeEntry)that);
    return false;
  }

  public boolean equals(TArrayTypeEntry that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_objectTypePtr = true;
    boolean that_present_objectTypePtr = true;
    if (this_present_objectTypePtr || that_present_objectTypePtr) {
      if (!(this_present_objectTypePtr && that_present_objectTypePtr))
        return false;
      if (this.objectTypePtr != that.objectTypePtr)
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + objectTypePtr;

    return hashCode;
  }

  @Override
  public int compareTo(TArrayTypeEntry other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetObjectTypePtr()).compareTo(other.isSetObjectTypePtr());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetObjectTypePtr()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.objectTypePtr, other.objectTypePtr);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TArrayTypeEntry(");
    boolean first = true;

    sb.append("objectTypePtr:");
    sb.append(this.objectTypePtr);
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    // alas, we cannot check 'objectTypePtr' because it's a primitive and you chose the non-beans generator.
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

  private static class TArrayTypeEntryStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TArrayTypeEntryStandardScheme getScheme() {
      return new TArrayTypeEntryStandardScheme();
    }
  }

  private static class TArrayTypeEntryStandardScheme extends org.apache.thrift.scheme.StandardScheme<TArrayTypeEntry> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TArrayTypeEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // OBJECT_TYPE_PTR
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.objectTypePtr = iprot.readI32();
              struct.setObjectTypePtrIsSet(true);
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
      if (!struct.isSetObjectTypePtr()) {
        throw new org.apache.thrift.protocol.TProtocolException("Required field 'objectTypePtr' was not found in serialized data! Struct: " + toString());
      }
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TArrayTypeEntry struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(OBJECT_TYPE_PTR_FIELD_DESC);
      oprot.writeI32(struct.objectTypePtr);
      oprot.writeFieldEnd();
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TArrayTypeEntryTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TArrayTypeEntryTupleScheme getScheme() {
      return new TArrayTypeEntryTupleScheme();
    }
  }

  private static class TArrayTypeEntryTupleScheme extends org.apache.thrift.scheme.TupleScheme<TArrayTypeEntry> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TArrayTypeEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeI32(struct.objectTypePtr);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TArrayTypeEntry struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.objectTypePtr = iprot.readI32();
      struct.setObjectTypePtrIsSet(true);
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

