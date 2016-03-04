import javax.swing.text.Segment

/**
  * Created by Florian on 04/03/16.
  */
class DifferentImplementationsFoldLeft {


  def fullDef(segments: Array[String]): Int = {
    def parseAndSum(acc: Int, current:String): Int = acc + current.toInt
    segments.foldLeft(0)(parseAndSum)
  }

  def inLineDef(segments: Array[String]): Int = {
    segments.foldLeft(0)((acc: Int, current: String) => acc + current.toInt)
  }

  def inferredTypes(segments: Array[String]): Int = {
    segments.foldLeft(0)((acc, current) => acc + current.toInt)
  }

  def magicDef(segments: Array[String]): Int = {
    segments.foldLeft(0)(_ + _.toInt)
  }

  def wrongMagicDeg(segments: Array[String]): Int = {
//    segments.foldLeft(0)(_.toInt + _)    <-- order matters when using wildcards
    0
  }
}
