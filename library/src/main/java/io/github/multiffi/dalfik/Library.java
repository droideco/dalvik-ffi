package io.github.multiffi.dalfik;

import android.annotation.SuppressLint;

import java.io.File;
import java.util.Objects;

public final class Library {

    private Library() {
        throw new AssertionError("No io.github.multiffi.dalfik.Library instances for you!");
    }

    static {
        System.loadLibrary("dalfik");
    }

    public static String mapName(String libraryName) {
        if (libraryName == null) return null;
        else if (libraryName.startsWith("lib") && libraryName.endsWith(".so")) return libraryName;
        else return System.mapLibraryName(libraryName);
    }

    public static void load(String libraryName) throws UnsatisfiedLinkError {
        Objects.requireNonNull(libraryName);
        File libraryFile = new File(libraryName);
        if (libraryFile.isAbsolute()) load(libraryFile);
        else if (libraryName.startsWith("lib") && libraryName.endsWith(".so"))
            libraryName = libraryName.substring(3, libraryName.length() - 3);
        System.loadLibrary(libraryName);
    }

    @SuppressLint("UnsafeDynamicallyLoadedCode")
    public static void load(File libraryFile) throws UnsatisfiedLinkError {
        Objects.requireNonNull(libraryFile);
        System.load(libraryFile.getAbsolutePath());
    }

    public static long find(String symbol) throws UnsatisfiedLinkError {
        long dlsym = dlsym(symbol);
        if (dlsym == 0L) {
            String error = dlerror();
            if (error == null) throw new UnsatisfiedLinkError();
            else throw new UnsatisfiedLinkError(error);
        }
        else return dlsym;
    }

    private static native long dlsym(String symbol);
    private static native String dlerror();

}
