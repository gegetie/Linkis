/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.impala.thrift;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked", "unused"})
@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-12-20")
public class TScalarFunction implements org.apache.thrift.TBase<TScalarFunction, TScalarFunction._Fields>, java.io.Serializable, Cloneable, Comparable<TScalarFunction> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TScalarFunction");

  private static final org.apache.thrift.protocol.TField SYMBOL_FIELD_DESC = new org.apache.thrift.protocol.TField("symbol", org.apache.thrift.protocol.TType.STRING, (short)1);
  private static final org.apache.thrift.protocol.TField PREPARE_FN_SYMBOL_FIELD_DESC = new org.apache.thrift.protocol.TField("prepare_fn_symbol", org.apache.thrift.protocol.TType.STRING, (short)2);
  private static final org.apache.thrift.protocol.TField CLOSE_FN_SYMBOL_FIELD_DESC = new org.apache.thrift.protocol.TField("close_fn_symbol", org.apache.thrift.protocol.TType.STRING, (short)3);

  private static final org.apache.thrift.scheme.SchemeFactory STANDARD_SCHEME_FACTORY = new TScalarFunctionStandardSchemeFactory();
  private static final org.apache.thrift.scheme.SchemeFactory TUPLE_SCHEME_FACTORY = new TScalarFunctionTupleSchemeFactory();

  public @org.apache.thrift.annotation.Nullable java.lang.String symbol; // required
  public @org.apache.thrift.annotation.Nullable java.lang.String prepare_fn_symbol; // optional
  public @org.apache.thrift.annotation.Nullable java.lang.String close_fn_symbol; // optional

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    SYMBOL((short)1, "symbol"),
    PREPARE_FN_SYMBOL((short)2, "prepare_fn_symbol"),
    CLOSE_FN_SYMBOL((short)3, "close_fn_symbol");

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
        case 1: // SYMBOL
          return SYMBOL;
        case 2: // PREPARE_FN_SYMBOL
          return PREPARE_FN_SYMBOL;
        case 3: // CLOSE_FN_SYMBOL
          return CLOSE_FN_SYMBOL;
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
  private static final _Fields optionals[] = {_Fields.PREPARE_FN_SYMBOL,_Fields.CLOSE_FN_SYMBOL};
  public static final java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    java.util.Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new java.util.EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.SYMBOL, new org.apache.thrift.meta_data.FieldMetaData("symbol", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.PREPARE_FN_SYMBOL, new org.apache.thrift.meta_data.FieldMetaData("prepare_fn_symbol", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    tmpMap.put(_Fields.CLOSE_FN_SYMBOL, new org.apache.thrift.meta_data.FieldMetaData("close_fn_symbol", org.apache.thrift.TFieldRequirementType.OPTIONAL, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = java.util.Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TScalarFunction.class, metaDataMap);
  }

  public TScalarFunction() {
  }

  public TScalarFunction(
    java.lang.String symbol)
  {
    this();
    this.symbol = symbol;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TScalarFunction(TScalarFunction other) {
    if (other.isSetSymbol()) {
      this.symbol = other.symbol;
    }
    if (other.isSetPrepare_fn_symbol()) {
      this.prepare_fn_symbol = other.prepare_fn_symbol;
    }
    if (other.isSetClose_fn_symbol()) {
      this.close_fn_symbol = other.close_fn_symbol;
    }
  }

  public TScalarFunction deepCopy() {
    return new TScalarFunction(this);
  }

  @Override
  public void clear() {
    this.symbol = null;
    this.prepare_fn_symbol = null;
    this.close_fn_symbol = null;
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getSymbol() {
    return this.symbol;
  }

  public TScalarFunction setSymbol(@org.apache.thrift.annotation.Nullable java.lang.String symbol) {
    this.symbol = symbol;
    return this;
  }

  public void unsetSymbol() {
    this.symbol = null;
  }

  /** Returns true if field symbol is set (has been assigned a value) and false otherwise */
  public boolean isSetSymbol() {
    return this.symbol != null;
  }

  public void setSymbolIsSet(boolean value) {
    if (!value) {
      this.symbol = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getPrepare_fn_symbol() {
    return this.prepare_fn_symbol;
  }

  public TScalarFunction setPrepare_fn_symbol(@org.apache.thrift.annotation.Nullable java.lang.String prepare_fn_symbol) {
    this.prepare_fn_symbol = prepare_fn_symbol;
    return this;
  }

  public void unsetPrepare_fn_symbol() {
    this.prepare_fn_symbol = null;
  }

  /** Returns true if field prepare_fn_symbol is set (has been assigned a value) and false otherwise */
  public boolean isSetPrepare_fn_symbol() {
    return this.prepare_fn_symbol != null;
  }

  public void setPrepare_fn_symbolIsSet(boolean value) {
    if (!value) {
      this.prepare_fn_symbol = null;
    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.String getClose_fn_symbol() {
    return this.close_fn_symbol;
  }

  public TScalarFunction setClose_fn_symbol(@org.apache.thrift.annotation.Nullable java.lang.String close_fn_symbol) {
    this.close_fn_symbol = close_fn_symbol;
    return this;
  }

  public void unsetClose_fn_symbol() {
    this.close_fn_symbol = null;
  }

  /** Returns true if field close_fn_symbol is set (has been assigned a value) and false otherwise */
  public boolean isSetClose_fn_symbol() {
    return this.close_fn_symbol != null;
  }

  public void setClose_fn_symbolIsSet(boolean value) {
    if (!value) {
      this.close_fn_symbol = null;
    }
  }

  public void setFieldValue(_Fields field, @org.apache.thrift.annotation.Nullable java.lang.Object value) {
    switch (field) {
    case SYMBOL:
      if (value == null) {
        unsetSymbol();
      } else {
        setSymbol((java.lang.String)value);
      }
      break;

    case PREPARE_FN_SYMBOL:
      if (value == null) {
        unsetPrepare_fn_symbol();
      } else {
        setPrepare_fn_symbol((java.lang.String)value);
      }
      break;

    case CLOSE_FN_SYMBOL:
      if (value == null) {
        unsetClose_fn_symbol();
      } else {
        setClose_fn_symbol((java.lang.String)value);
      }
      break;

    }
  }

  @org.apache.thrift.annotation.Nullable
  public java.lang.Object getFieldValue(_Fields field) {
    switch (field) {
    case SYMBOL:
      return getSymbol();

    case PREPARE_FN_SYMBOL:
      return getPrepare_fn_symbol();

    case CLOSE_FN_SYMBOL:
      return getClose_fn_symbol();

    }
    throw new java.lang.IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new java.lang.IllegalArgumentException();
    }

    switch (field) {
    case SYMBOL:
      return isSetSymbol();
    case PREPARE_FN_SYMBOL:
      return isSetPrepare_fn_symbol();
    case CLOSE_FN_SYMBOL:
      return isSetClose_fn_symbol();
    }
    throw new java.lang.IllegalStateException();
  }

  @Override
  public boolean equals(java.lang.Object that) {
    if (that == null)
      return false;
    if (that instanceof TScalarFunction)
      return this.equals((TScalarFunction)that);
    return false;
  }

  public boolean equals(TScalarFunction that) {
    if (that == null)
      return false;
    if (this == that)
      return true;

    boolean this_present_symbol = true && this.isSetSymbol();
    boolean that_present_symbol = true && that.isSetSymbol();
    if (this_present_symbol || that_present_symbol) {
      if (!(this_present_symbol && that_present_symbol))
        return false;
      if (!this.symbol.equals(that.symbol))
        return false;
    }

    boolean this_present_prepare_fn_symbol = true && this.isSetPrepare_fn_symbol();
    boolean that_present_prepare_fn_symbol = true && that.isSetPrepare_fn_symbol();
    if (this_present_prepare_fn_symbol || that_present_prepare_fn_symbol) {
      if (!(this_present_prepare_fn_symbol && that_present_prepare_fn_symbol))
        return false;
      if (!this.prepare_fn_symbol.equals(that.prepare_fn_symbol))
        return false;
    }

    boolean this_present_close_fn_symbol = true && this.isSetClose_fn_symbol();
    boolean that_present_close_fn_symbol = true && that.isSetClose_fn_symbol();
    if (this_present_close_fn_symbol || that_present_close_fn_symbol) {
      if (!(this_present_close_fn_symbol && that_present_close_fn_symbol))
        return false;
      if (!this.close_fn_symbol.equals(that.close_fn_symbol))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    int hashCode = 1;

    hashCode = hashCode * 8191 + ((isSetSymbol()) ? 131071 : 524287);
    if (isSetSymbol())
      hashCode = hashCode * 8191 + symbol.hashCode();

    hashCode = hashCode * 8191 + ((isSetPrepare_fn_symbol()) ? 131071 : 524287);
    if (isSetPrepare_fn_symbol())
      hashCode = hashCode * 8191 + prepare_fn_symbol.hashCode();

    hashCode = hashCode * 8191 + ((isSetClose_fn_symbol()) ? 131071 : 524287);
    if (isSetClose_fn_symbol())
      hashCode = hashCode * 8191 + close_fn_symbol.hashCode();

    return hashCode;
  }

  @Override
  public int compareTo(TScalarFunction other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = java.lang.Boolean.valueOf(isSetSymbol()).compareTo(other.isSetSymbol());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetSymbol()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.symbol, other.symbol);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetPrepare_fn_symbol()).compareTo(other.isSetPrepare_fn_symbol());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrepare_fn_symbol()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.prepare_fn_symbol, other.prepare_fn_symbol);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = java.lang.Boolean.valueOf(isSetClose_fn_symbol()).compareTo(other.isSetClose_fn_symbol());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetClose_fn_symbol()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.close_fn_symbol, other.close_fn_symbol);
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
    java.lang.StringBuilder sb = new java.lang.StringBuilder("TScalarFunction(");
    boolean first = true;

    sb.append("symbol:");
    if (this.symbol == null) {
      sb.append("null");
    } else {
      sb.append(this.symbol);
    }
    first = false;
    if (isSetPrepare_fn_symbol()) {
      if (!first) sb.append(", ");
      sb.append("prepare_fn_symbol:");
      if (this.prepare_fn_symbol == null) {
        sb.append("null");
      } else {
        sb.append(this.prepare_fn_symbol);
      }
      first = false;
    }
    if (isSetClose_fn_symbol()) {
      if (!first) sb.append(", ");
      sb.append("close_fn_symbol:");
      if (this.close_fn_symbol == null) {
        sb.append("null");
      } else {
        sb.append(this.close_fn_symbol);
      }
      first = false;
    }
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (symbol == null) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'symbol' was not present! Struct: " + toString());
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

  private static class TScalarFunctionStandardSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TScalarFunctionStandardScheme getScheme() {
      return new TScalarFunctionStandardScheme();
    }
  }

  private static class TScalarFunctionStandardScheme extends org.apache.thrift.scheme.StandardScheme<TScalarFunction> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TScalarFunction struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // SYMBOL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.symbol = iprot.readString();
              struct.setSymbolIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // PREPARE_FN_SYMBOL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.prepare_fn_symbol = iprot.readString();
              struct.setPrepare_fn_symbolIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 3: // CLOSE_FN_SYMBOL
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.close_fn_symbol = iprot.readString();
              struct.setClose_fn_symbolIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TScalarFunction struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.symbol != null) {
        oprot.writeFieldBegin(SYMBOL_FIELD_DESC);
        oprot.writeString(struct.symbol);
        oprot.writeFieldEnd();
      }
      if (struct.prepare_fn_symbol != null) {
        if (struct.isSetPrepare_fn_symbol()) {
          oprot.writeFieldBegin(PREPARE_FN_SYMBOL_FIELD_DESC);
          oprot.writeString(struct.prepare_fn_symbol);
          oprot.writeFieldEnd();
        }
      }
      if (struct.close_fn_symbol != null) {
        if (struct.isSetClose_fn_symbol()) {
          oprot.writeFieldBegin(CLOSE_FN_SYMBOL_FIELD_DESC);
          oprot.writeString(struct.close_fn_symbol);
          oprot.writeFieldEnd();
        }
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TScalarFunctionTupleSchemeFactory implements org.apache.thrift.scheme.SchemeFactory {
    public TScalarFunctionTupleScheme getScheme() {
      return new TScalarFunctionTupleScheme();
    }
  }

  private static class TScalarFunctionTupleScheme extends org.apache.thrift.scheme.TupleScheme<TScalarFunction> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TScalarFunction struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol oprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      oprot.writeString(struct.symbol);
      java.util.BitSet optionals = new java.util.BitSet();
      if (struct.isSetPrepare_fn_symbol()) {
        optionals.set(0);
      }
      if (struct.isSetClose_fn_symbol()) {
        optionals.set(1);
      }
      oprot.writeBitSet(optionals, 2);
      if (struct.isSetPrepare_fn_symbol()) {
        oprot.writeString(struct.prepare_fn_symbol);
      }
      if (struct.isSetClose_fn_symbol()) {
        oprot.writeString(struct.close_fn_symbol);
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TScalarFunction struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TTupleProtocol iprot = (org.apache.thrift.protocol.TTupleProtocol) prot;
      struct.symbol = iprot.readString();
      struct.setSymbolIsSet(true);
      java.util.BitSet incoming = iprot.readBitSet(2);
      if (incoming.get(0)) {
        struct.prepare_fn_symbol = iprot.readString();
        struct.setPrepare_fn_symbolIsSet(true);
      }
      if (incoming.get(1)) {
        struct.close_fn_symbol = iprot.readString();
        struct.setClose_fn_symbolIsSet(true);
      }
    }
  }

  private static <S extends org.apache.thrift.scheme.IScheme> S scheme(org.apache.thrift.protocol.TProtocol proto) {
    return (org.apache.thrift.scheme.StandardScheme.class.equals(proto.getScheme()) ? STANDARD_SCHEME_FACTORY : TUPLE_SCHEME_FACTORY).getScheme();
  }
}

