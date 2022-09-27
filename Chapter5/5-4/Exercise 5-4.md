# Exercise 5-4.



<br>



## 1. 중복 LinearLayout 사용

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    tools:context=".MainActivity">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="horizontal">

        <TextView
            android:id="@+id/textView"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="전화번호"
            android:textAppearance="@style/TextAppearance.AppCompat.Large" />

        <EditText
            android:id="@+id/editText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:hint="000-0000-0000"
            android:textAppearance="@style/TextAppearance.AppCompat.Large" />
    </LinearLayout>

    <LinearLayout
        android:orientation="horizontal"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:gravity="right">

        <Button
            android:id="@+id/btnInput"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="입력" />
        <Button
            android:id="@+id/btnCancel"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="취소" />
    </LinearLayout>
  
</LinearLayout>
```





<br>



## 2. RelativeLayout 사용

```xml
<?xml version="1.0" encoding="utf-8"?>
<RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    tools:context=".MainActivity">

    <TextView
        android:id="@+id/textView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentLeft="true"
        android:text="전화번호"
        android:textAppearance="@style/TextAppearance.AppCompat.Large" />

    <EditText
        android:id="@+id/editPhoneNum"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:hint="000-0000-0000"
        android:textAppearance="@style/TextAppearance.AppCompat.Large"
        android:layout_toRightOf="@id/textView"
        android:layout_alignBaseline="@id/textView"/>

    <Button
        android:id="@+id/btnCancel"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="취소"
        android:layout_below="@id/editPhoneNum"
        android:layout_alignRight="@id/editPhoneNum"/>

    <Button
        android:id="@+id/btnInput"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:text="입력"
        android:layout_alignBaseline="@id/btnCancel"
        android:layout_toLeftOf="@id/btnCancel"/>

</RelativeLayout>
```

