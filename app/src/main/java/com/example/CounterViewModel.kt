import androidx.lifecycle.ViewModel

class CounterViewModel : ViewModel() {

    private var counter: Int = 0
    private var isIncrementMode: Boolean = true

    fun updateCounter() {
        if (isIncrementMode) {
            if (counter < 10) {
                counter++
            } else {
                isIncrementMode = false
            }
        } else {
            if (counter > 0) {
                counter--
            } else {
                isIncrementMode = true
                counter = 0
            }
        }
    }

    fun getCounter(): Int {
        return counter
    }

    fun isIncrementMode(): Boolean {
        return isIncrementMode
    }
}
