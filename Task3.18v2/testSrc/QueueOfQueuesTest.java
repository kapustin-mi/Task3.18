import cs.vsu.ru.kapustin.QueueOfQueues;
import org.junit.Assert;
import org.junit.Test;

public class QueueOfQueuesTest {
    QueueOfQueues queueOfQueues = new QueueOfQueues();

    @Test
    public void createQueueWithLength0() {
        String expected = "[]";
        String actual = String.valueOf(queueOfQueues.create(0));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createQueueWithLength1() {
        String expected = "[[1]]";
        String actual = String.valueOf(queueOfQueues.create(1));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createQueueWithLengthMinus1() {
        String expected = "[]";
        String actual = String.valueOf(queueOfQueues.create(-1));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createQueueWithLength2() {
        String expected = "[[1], [1, 2]]";
        String actual = String.valueOf(queueOfQueues.create(2));

        Assert.assertEquals(expected, actual);
    }

    @Test
    public void createQueueWithLength5() {
        String expected = "[[1], [1, 2], [1, 2, 3], [1, 2, 3, 4], [1, 2, 3, 4, 5]]";
        String actual = String.valueOf(queueOfQueues.create(5));

        Assert.assertEquals(expected, actual);
    }
}