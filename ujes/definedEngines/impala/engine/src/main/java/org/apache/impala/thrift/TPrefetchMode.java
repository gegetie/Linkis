/**
 * Autogenerated by Thrift Compiler (0.12.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.impala.thrift;


@javax.annotation.Generated(value = "Autogenerated by Thrift Compiler (0.12.0)", date = "2019-09-12")
public enum TPrefetchMode implements org.apache.thrift.TEnum {
  NONE(0),
  HT_BUCKET(1);

  private final int value;

  private TPrefetchMode(int value) {
    this.value = value;
  }

  /**
   * Get the integer value of this enum value, as defined in the Thrift IDL.
   */
  public int getValue() {
    return value;
  }

  /**
   * Find a the enum type by its integer value, as defined in the Thrift IDL.
   * @return null if the value is not found.
   */
  @org.apache.thrift.annotation.Nullable
  public static TPrefetchMode findByValue(int value) { 
    switch (value) {
      case 0:
        return NONE;
      case 1:
        return HT_BUCKET;
      default:
        return null;
    }
  }
}
