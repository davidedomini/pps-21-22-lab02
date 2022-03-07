package Tasks

object Es6 extends App:
  def fib(n: Int): Int = n match
    case 0 => 0
    case 1 => 1
    case _ => fib(n-1) + fib(n-2)
  //The implementation above isn't a tail recursion

  //Here we have a tail recursive implementation, we can check that it is eeffectively tail with the annotation below
  def fibTail(n: Int): Int =
    @annotation.tailrec
    def _fib(n: Int, prev: Int, current: Int): Int = n match
      case 0 => current
      case _ => _fib(n-1, prev + current, prev)

    _fib(n,1,0)
