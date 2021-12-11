package basic

import java.time.LocalDate

class Print {
  /**
   * 呼ぶときはメインクラスに次のように書く
   * object Main {
   * def main(args: Array[String]): Unit = {
   * val print = new Print
   * print.func1() //=> basic.Print$$Lambda$15/0x0000000800098040@9a7504c
   * }
   * }
   */

  def lazyDate(): Unit = {
    /** 出力結果
     * 2021-12-11
     */
    lazy val lazyDate = LocalDate.now();
    println(lazyDate)
    System.out.println(lazyDate)
  }

  def lazyDate2(): Unit = {
    /** 出力結果
     * now loading...
     * 2021-12-11
     * 2021-12-11
     */
    lazy val lazyDate = {
      println("now loading...")
      LocalDate.now();
    }
    println(lazyDate)
    println(lazyDate) //2回目は最終行でreturnされた値のみ出力する仕様
  }

  def echo(value: String): Unit = {
    /** 出力結果
     * call: echo("Hello")
     * Hello
     */
    println(value)
  }

  def double(value: Int) = {
    /** 結果
     * call: print(double(32))
     * 64
     */
    value * 2
  }

  def func1(): Unit = {
    /** 結果
     * Main$$$Lambda$17/0x00000008000d7840@3e57cd70
     */
    val echoAsFunction = echo _
    println(echoAsFunction)
  }

  def func2(): Unit = {
    /** 結果
     * _ must follow method; cannot follow Unit
     */
    //    val echoAsFunction = echo("Hello") _
    //    println(echoAsFunction)
  }

  def func3(): Unit = {
    /** 結果
     * call: func3()
     * func3
     */
    val echoAsFunction = echo _
    echoAsFunction.apply("func3")
  }

  def func4(): Unit = {
    /** 結果
     * call: func4()
     * Main$$$Lambda$17/0x00000008000d7840@3e57cd70
     */
    val echoAsFunction = (value: String) => println(value)
    println(echoAsFunction)
  }

  def func5(): Unit = {
    /** 結果
     * List()
     * name: Function1を関数オブジェクトと呼ぶ
     */
    val echoAsFunction = new Function1[String, Boolean] {
      def apply(str: String) = str.matches("[a-zA-Z0-9\\s]")
    }
    val word = Seq("Scala", "2.12")
    val echoWords = word.filter(echoAsFunction)
    println(echoWords)
  }
}
