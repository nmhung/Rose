package net.fitken.rose


object StackTraceInfo {
    private val CLIENT_CODE_STACK_INDEX: Int

    // making additional overloaded method
    // call requires +1 offset
    val currentMethodName: String
        get() = getCurrentMethodName(1)

    // making additional overloaded method
    // call requires +1 offset
    val currentClassName: String
        get() = getCurrentClassName(1)

    // making additional overloaded method
    // call requires +1 offset
    val currentFileName: String
        get() = getCurrentFileName(1)

    val invokingMethodName: String
        get() = getInvokingMethodName(2)

    val invokingClassName: String
        get() = getInvokingClassName(2)

    val invokingFileName: String
        get() = getInvokingFileName(2)

    val currentMethodNameFqn: String
        get() = getCurrentMethodNameFqn(1)

    val currentFileNameFqn: String
        get() {
            val CurrentMethodNameFqn = getCurrentMethodNameFqn(1)
            val currentFileName = getCurrentFileName(1)
            return "$CurrentMethodNameFqn($currentFileName)"
        }

    val invokingMethodNameFqn: String
        get() = getInvokingMethodNameFqn(2)

    val invokingFileNameFqn: String
        get() {
            val invokingMethodNameFqn = getInvokingMethodNameFqn(2)
            val invokingFileName = getInvokingFileName(2)
            return "$invokingMethodNameFqn($invokingFileName)"
        }

    init {
        // Finds out the index of "this code" in the returned stack trace -
        // funny but it differs in JDK 1.5 and 1.6
        var i = 0
        for (ste in Thread.currentThread().stackTrace) {
            i++
            if (ste.className == StackTraceInfo::class.java.name) {
                break
            }
        }
        CLIENT_CODE_STACK_INDEX = i
    }

    private fun getCurrentMethodName(offset: Int): String {
        return Thread.currentThread().stackTrace[CLIENT_CODE_STACK_INDEX + offset].methodName
    }

    private fun getCurrentClassName(offset: Int): String {
        return Thread.currentThread().stackTrace[CLIENT_CODE_STACK_INDEX + offset].className
    }

    private fun getCurrentFileName(offset: Int): String {
        val filename = Thread.currentThread().stackTrace[CLIENT_CODE_STACK_INDEX + offset].fileName
        val lineNumber = Thread.currentThread().stackTrace[CLIENT_CODE_STACK_INDEX + offset].lineNumber
        return "$filename:$lineNumber"
    }

    private fun getInvokingMethodName(offset: Int): String {
        return getCurrentMethodName(offset + 1) // re-uses
        // getCurrentMethodName() with
        // desired index
    }

    private fun getInvokingClassName(offset: Int): String {
        return getCurrentClassName(offset + 1) // re-uses getCurrentClassName()
        // with desired index
    }

    private fun getInvokingFileName(offset: Int): String {
        return getCurrentFileName(offset + 1) // re-uses getCurrentFileName()
        // with desired index
    }

    private fun getCurrentMethodNameFqn(offset: Int): String {
        val currentClassName = getCurrentClassName(offset + 1)
        val currentMethodName = getCurrentMethodName(offset + 1)
        return "$currentClassName.$currentMethodName"
    }

    private fun getInvokingMethodNameFqn(offset: Int): String {
        val invokingClassName = getInvokingClassName(offset + 1)
        val invokingMethodName = getInvokingMethodName(offset + 1)
        return "$invokingClassName.$invokingMethodName"
    }
}
