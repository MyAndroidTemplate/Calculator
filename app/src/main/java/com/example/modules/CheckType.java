package com.example.modules;

public class CheckType<T> {
        public static <T> boolean isDouble(T value) {
            return value instanceof Double;
        }

        public static <T> boolean isLong(T value) {
            return value instanceof Long;
        }
        public static <T> boolean isInteger(T value) {
            return value instanceof Integer;
        }
    }
