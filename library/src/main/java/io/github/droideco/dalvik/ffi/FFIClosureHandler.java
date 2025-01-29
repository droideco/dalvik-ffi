package io.github.droideco.dalvik.ffi;

import java.util.Objects;

@FunctionalInterface
public interface FFIClosureHandler extends FFIRawClosureHandler {

    Object invoke(Object... args) throws Throwable;

    @Override
    default void invoke(FFICallContext context, long rvalue, long avalues) throws Throwable {
        FFIType rtype = context.rtype;
        FFIType[] atypes = context.atypes;
        Object[] args = new Object[atypes.length];
        for (int i = 0; i < atypes.length; i ++) {
            FFIType atype = atypes[i];
            long avalue = Memory.getAddress(avalues + Memory.ADDRESS_SIZE * i);
            if (atype == FFIType.SINT8) args[i] = Memory.getByte(avalue);
            else if (atype == FFIType.SINT16) args[i] = Memory.getShort(avalue);
            else if (atype == FFIType.JCHAR) args[i] = Memory.getChar(avalue);
            else if (atype == FFIType.SINT32 || atype == FFIType.WCHAR) args[i] = Memory.getInt(avalue);
            else if (atype == FFIType.SINT64) args[i] = Memory.getLong(avalue);
            else if (atype == FFIType.FLOAT) args[i] = Memory.getFloat(avalue);
            else if (atype == FFIType.DOUBLE) args[i] = Memory.getDouble(avalue);
            else if (atype == FFIType.POINTER || atype == FFIType.SIZE) args[i] = Memory.getAddress(avalue);
            else if (atype == FFIType.BOOLEAN) args[i] = Memory.getAddress(avalue) != 0;
            else if (atype == FFIType.LONG) args[i] = Memory.getNativeLong(avalue);
            else args[i] = avalue;
        }
        Object result = invoke(args);
        if (rtype != FFIType.VOID) {
            Objects.requireNonNull(result);
            if (rtype == FFIType.SINT8) Memory.putByte(rvalue, ((Number) result).byteValue());
            else if (rtype == FFIType.SINT16) Memory.putShort(rvalue, ((Number) result).shortValue());
            else if (rtype == FFIType.JCHAR) Memory.putChar(rvalue, (Character) result);
            else if (rtype == FFIType.SINT32 || rtype == FFIType.WCHAR) Memory.putInt(rvalue, ((Number) result).intValue());
            else if (rtype == FFIType.SINT64) Memory.putLong(rvalue, ((Number) result).longValue());
            else if (rtype == FFIType.FLOAT) Memory.putFloat(rvalue, ((Number) result).floatValue());
            else if (rtype == FFIType.DOUBLE) Memory.putDouble(rvalue, ((Number) result).doubleValue());
            else if (rtype == FFIType.POINTER || rtype == FFIType.SIZE) Memory.putAddress(rvalue, ((Number) result).longValue());
            else if (rtype == FFIType.BOOLEAN) Memory.putAddress(rvalue, ((Boolean) result) ? 1 : 0);
            else if (rtype == FFIType.LONG) Memory.putNativeLong(rvalue, ((Number) result).longValue());
            else Memory.copy(rvalue, (long) result, rtype.size);
        }
    }

}
