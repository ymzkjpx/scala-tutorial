package basic

class IfSwitch {

  def func1(): Unit = {
    /** 結果
     * NG
     */
    val weight = 60
    var message: String = null
    if (weight <= 50) {
      message = "OK"
    } else {
      message = "NG"
    }
    println(message)
  }

  def func2(): Unit = {
    /** 結果
     * OK
     */
    val weight = 60
    val message = if (weight <= 100) {
      "OK"
    } else {
      "NG"
    }
    println(message)
  }

  def func3(): Unit = {
    /** 結果
     * OK
     */
    val weight = 60
    val message = if (weight <= 70) "OK" else "NG"
    println(message)
  }

  def func4(): Unit = {
    /** 結果
     * Other
     * name: match式
     */
    val n = 5
    n match {
      case 1 => println(1)
      case 2 => println(2)
      case other => println("Other")
    }
  }

  def func5(): Unit = {
    /** 結果
     * Some(123)
     * None
     * name: Option型はnullやnilであるかもしれないことを表現する型で、JavaのOptional型に近い
     */
    val maybeNum: Option[Int] = Some(123)
    println(maybeNum)
    val maybeInt: Option[Int] = None
    println(maybeInt)
  }

  def func6(): Unit = {
    /**
     * 123
     * description: maybeNumがmatch式に渡され、match式内でnという名前に置き換わり評価される。評価された結果がnumに返却・格納される。SomeはOptionのCaseClass??よくわからない。
     */
    val maybeNum: Option[Int] = Some(123)
    val num: Int = maybeNum match {
      case Some(n) if n < 0 => 0
      case Some(n) => n
      case None => 0
    }
    println(num)
  }

}
