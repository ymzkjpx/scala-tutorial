package basic

class Loop {
  /**
   * ScalaではWhile, forは式である。文ではない。
   * ScalaではWhile式の戻り値はUnitであり、Voidに近い。ただし、そもそもWhile式はほとんど利用されない。
   */

  def func1(): Unit = {
    /** 結果
     * List(2, 3)
     * description: .filterはコレクションのメソッド
     */
    val filtered = Seq(1, 2, 3).filter(i => i > 1)
    println(filtered)
  }

  def func2(): Unit = {
    /** 結果
     * List(2, 4, 6)
     * description: .mapはコレクションのメソッド
     */
    val mapped = Seq(1, 2, 3).map(i => i * 2)
    println(mapped)
  }

  def func3(): Unit = {
    /** 結果
     * 1
     * 2
     * 3
     * List(2, 4, 6)
     * description: mao内を複数記述したい場合は{}を利用する。
     */
    val mapped = Seq(1, 2, 3).map { i =>
      println(i)
      i * 2
    }
    println(mapped)
  }

  def func4(): Unit = {
    /** 結果
     * List(1, 2, 3, 4)
     */
    val flatten = Seq(Seq(1, 2), Seq(3, 4)).flatMap(s => s)
    println(flatten)
  }

}
