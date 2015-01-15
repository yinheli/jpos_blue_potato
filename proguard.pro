-dontnote
-dontwarn
-overloadaggressively
-repackageclasses ''
-allowaccessmodification
-mergeinterfacesaggressively
-printseeds
-dontoptimize
-keepattributes SourceFile,LineNumberTable
-keepattributes *Annotation*

-keep public class com.elegantpay.** {
    public *;
}

-keepclassmembernames class * {
    java.lang.Class class$(java.lang.String);
    java.lang.Class class$(java.lang.String, boolean);
}

-keepclasseswithmembernames,includedescriptorclasses class * {
    native <methods>;
}

-keepclassmembers,allowoptimization enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}