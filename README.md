# Android Material Dialog 演示

## 简介

本 Demo 演示 Material Design 对话框的使用。

## 教程

```kotlin
MaterialAlertDialogBuilder(this)
    .setTitle("标题")
    .setMessage("内容")
    .setPositiveButton("确定") { _, _ -> }
    .setNegativeButton("取消") { _, _ -> }
    .show()
```
