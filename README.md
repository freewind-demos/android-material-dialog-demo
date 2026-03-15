# Android Material Dialog 演示

## 简介

本 Demo 演示 Material Design 对话框（Material Dialog）的使用，展示如何创建现代化的对话框。

## 基本原理

Material Dialog 是 Material Design 组件库提供的对话框组件，基于 AlertDialog 但提供了更好的视觉效果和交互体验。

Material Dialog 的特点：
- 遵循 Material Design 设计规范
- 支持多种按钮类型（Positive、Negative、Neutral）
- 支持自定义布局
- 圆角边框和统一的视觉风格

## 启动和使用

### 环境要求
- Android Studio
- JDK 17
- Gradle 8.x
- Material Components 库

### 安装和运行

1. 用 Android Studio 打开项目
2. 连接 Android 设备或模拟器
3. 点击 Run 运行

### 使用方法
- 点击"显示对话框"按钮弹出对话框
- 点击确定或取消按钮查看结果

## 教程

### 什么是 Material Dialog？

Material Dialog 是 Google 官方 Material Design 组件库提供的对话框组件。它相比传统的 AlertDialog 具有更好的视觉效果，包括圆角、阴影和统一的 Material 风格。

### 基本用法

使用 MaterialAlertDialogBuilder 创建对话框：

```kotlin
MaterialAlertDialogBuilder(context)
    .setTitle("标题")           // 设置对话框标题
    .setMessage("内容")          // 设置对话框内容
    .setPositiveButton("确定") { dialog, which ->
        // 点击确定按钮的处理
    }
    .setNegativeButton("取消") { dialog, which ->
        // 点击取消按钮的处理
    }
    .setNeutralButton("忽略") { dialog, which ->
        // 点击忽略按钮的处理
    }
    .show()                     // 显示对话框
```

### 带选项的对话框

可以创建单选或多选对话框：

```kotlin
val items = arrayOf("选项1", "选项2", "选项3")
var selectedItem = 0

MaterialAlertDialogBuilder(this)
    .setTitle("请选择")
    .setSingleChoiceItems(items, selectedItem) { _, which ->
        selectedItem = which
    }
    .setPositiveButton("确定") { _, _ ->
        // 确认选择
    }
    .show()
```

### 带输入框的对话框

```kotlin
MaterialAlertDialogBuilder(this)
    .setTitle("输入姓名")
    .setView(R.layout.dialog_input)  // 自定义布局
    .setPositiveButton("确定") { _, _ ->
        // 获取输入内容
    }
    .show()
```

### 注意事项

1. **依赖库**：需要添加 Material Components 依赖
2. **按钮回调**：Lambda 表达式中不需要使用 dialog 参数可以用 `_` 替代
3. **链式调用**：Builder 模式支持链式调用

## 关键代码详解

### MainActivity.kt

```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var resultText: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 1. 获取 TextView 组件
        resultText = findViewById(R.id.resultText)

        // 2. 设置按钮点击事件
        findViewById<Button>(R.id.showDialogBtn).setOnClickListener {
            // 3. 创建 Material Dialog
            MaterialAlertDialogBuilder(this)
                // 设置标题
                .setTitle("Material Dialog")
                // 设置消息内容
                .setMessage("这是一个 Material Design 对话框")
                // 设置确定按钮及回调
                .setPositiveButton("确定") { _, _ ->
                    resultText.text = "点击了确定"
                }
                // 设置取消按钮及回调
                .setNegativeButton("取消") { _, _ ->
                    resultText.text = "点击了取消"
                }
                // 显示对话框
                .show()
        }
    }
}
```

### activity_main.xml

```xml
<!-- 根布局：垂直线性布局 -->
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical"
    android:padding="16dp">

    <!-- 标题 -->
    <TextView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="Material Dialog 演示"
        android:textSize="20sp"
        android:textStyle="bold"
        android:gravity="center"
        android:paddingBottom="16dp" />

    <!-- 显示对话框按钮 -->
    <Button
        android:id="@+id/showDialogBtn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:text="显示对话框" />

    <!-- 显示结果的 TextView -->
    <TextView
        android:id="@+id/resultText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:paddingTop="16dp" />
</LinearLayout>
```
