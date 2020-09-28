package com.example.todo.common;

public final class Utils {

    private Utils() {
        // インスタンス生成を防止
    }

    public static boolean convertToBool(Integer isX) {

        if (isX == null) {
            return false;
        }
        switch (isX) {
            case 0:
                return false;
            case 1:
                return true;
            default:
                throw new IllegalArgumentException("Unkown parameter values.");
        }
    }

}
