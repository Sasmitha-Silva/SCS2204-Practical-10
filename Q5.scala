def countOccurrences(wordList: List[String]): Int = {
  val wordLengths = wordList.map(_.length)
  wordLengths.reduce(_ + _)
}

@main
def main(): Unit = {

  val wordList = List("apple", "banana", "cherry", "date")

  val tot = countOccurrences(wordList)
  println(s"Total count of letter occurrences: $tot")
}
