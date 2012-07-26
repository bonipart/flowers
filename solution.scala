import io.Source

object Solution extends App {
	val lines = Source.stdin.getLines.toList
	val List(n,k) = lines.head.split(" ").toList.map(_.toInt)
	val flowers = lines.tail.head.split(" ").toList.map(_.toInt).sorted
	val indexedFlowers = flowers.reverse.zipWithIndex

	println(flowers.sorted.reverse.zipWithIndex.foldLeft((0, 0))((b, a) => {
            val (count, factor) = b
            val (value, i) = a
            val y = if ((i % k) == 0) { factor + 1 } else factor
            ((value * y) + count) -> y
    })._1)
}
