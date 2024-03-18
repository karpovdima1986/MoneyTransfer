import org.junit.Test
import kotlin.test.assertEquals

class ComissionTest {

    @Test
    fun testVisa(){
        val type ="Visa"
        val transfer = 1_000
        val previous = 0

        val result = comission (type ,transfer, previous)

        assertEquals(35,result )
    }
    @Test
    fun testVisaLimit(){
        val type ="Visa"
        val transfer = 140_000
        val previous = 510_000

        val result = comission (type ,transfer, previous)

        assertEquals(ERROR_LIMIT,result )
    }
    @Test
    fun testWrongCard(){
        val type ="Union"
        val transfer = 1_000
        val previous = 10_000

        val result = comission (type ,transfer, previous)

        assertEquals(ERROR_TYPE,result )
    }
    @Test
    fun testVisaBig(){
        val type ="Visa"
        val transfer = 10_000
        val previous = 0

        val result = comission (type ,transfer, previous)

        assertEquals(75,result )
    }
    @Test
    fun testVisaDayLimit(){
        val type ="Visa"
        val transfer = 150_000
        val previous = 0

        val result = comission (type ,transfer, previous)

        assertEquals(ERROR_LIMIT,result )
    }
    @Test
    fun testVisaDaNoLimit(){
        val type ="Visa"
        val transfer = 140_000
        val previous = 250_000

        val result = comission (type ,transfer, previous)

        assertEquals(1050,result )
    }

    @Test
    fun testMastercardMin(){
        val type ="Mastercard"
        val transfer = 400
        val previous = 1000

        val result = comission (type ,transfer, previous)

        assertEquals(0,result )
    }
    @Test
    fun testMastercardMin2(){
        val type ="Mastercard"
        val transfer = 250
        val previous = 0

        val result = comission (type ,transfer, previous)

        assertEquals(21,result )
    }
    @Test
    fun testMastercardMax(){
        val type ="Mastercard"
        val transfer = 75_000
        val previous = 1000

        val result = comission (type ,transfer, previous)

        assertEquals(470,result )
    }
    @Test
    fun testVkPayTransfer(){
        val type ="Vk Pay"
        val transfer = 13_000
        val previous = 0

        val result = comission (type ,transfer, previous)

        assertEquals(0,result )
    }
    @Test
    fun testVkPayTransferAndPrevious(){
        val type ="Vk Pay"
        val transfer = 13_000
        val previous = 20_00

        val result = comission (type ,transfer, previous)

        assertEquals(0,result )
    }
    @Test
    fun testVkPayLimit(){
        val type ="Vk Pay"
        val transfer = 16_000
        val previous = 0

        val result = comission (type ,transfer, previous)

        assertEquals(ERROR_LIMIT_VK,result )
    }
    @Test
    fun testVkPayLimit2(){
        val type ="Vk Pay"
        val transfer = 14_000
        val previous = 32_000

        val result = comission (type ,transfer, previous)

        assertEquals(ERROR_LIMIT_VK,result )
    }



}