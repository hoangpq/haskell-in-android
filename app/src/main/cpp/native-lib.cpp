#include <jni.h>
#include <string>

// extern "C" int* eval(const char*, int*);
extern "C" void my_enter(void);
extern "C" int len(const char*);

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_sample_1hs_MainActivity_stringFromJNI(JNIEnv* env,
                                                       jobject /* this */,
                                                       jstring jstr) {
  jboolean isCopy;
  auto length = len(env->GetStringUTFChars(jstr, &isCopy));
  auto utf_string = env->GetStringUTFChars(jstr, &isCopy);
  if (isCopy == JNI_TRUE) {
    env->ReleaseStringUTFChars(jstr, utf_string);
  }

  return env->NewStringUTF(std::to_string(length).c_str());
}

extern "C" JNIEXPORT void JNICALL
Java_com_example_sample_1hs_MainActivityKt_hsInit(JNIEnv* env, jclass clazz) {
  // TODO: implement hsInit()
}