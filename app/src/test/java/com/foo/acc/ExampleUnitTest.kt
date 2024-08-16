package com.foo.acc

import androidx.compose.ui.graphics.Color
import com.foo.acc.ui.theme.GryffindorPrimaryColor
import com.foo.acc.ui.theme.Houses
import com.foo.acc.ui.utils.formatDate
import com.foo.acc.ui.utils.formatSpecies
import com.foo.acc.ui.utils.getHouseColor
import com.foo.acc.ui.utils.getInitials
import com.foo.acc.ui.utils.getLifeStatus
import org.junit.Assert.assertEquals
import org.junit.Test

class UtilsTests {
    @Test
    fun getLifeStatusAlive() {
        val actual = getLifeStatus(true)
        val expected = "Alive"
        assertEquals(expected, actual)
    }

    @Test
    fun getLifeStatusDead() {
        val actual = getLifeStatus(false)
        val expected = "Dead"
        assertEquals(expected, actual)
    }

    @Test
    fun getHouseColorKnown() {
        val actual = getHouseColor(Houses.GRYFFINDOR)
        val expected = GryffindorPrimaryColor
        assertEquals(expected, actual)
    }

    @Test
    fun getHouseColorUnknown() {
        val actual = getHouseColor("")
        val expected = Color.LightGray
        assertEquals(expected, actual)
    }

    @Test
    fun formatSpeciesSuccess() {
        val actual = formatSpecies("human")
        val expected = "Human"
        assertEquals(expected, actual)
    }

    @Test
    fun getInitialsWithName() {
        val actual = getInitials("Harry Potter")
        val expected = "H"
        assertEquals(expected, actual)
    }

    @Test
    fun getInitialsWithoutName() {
        val actual = getInitials("")
        val expected = "?"
        assertEquals(expected, actual)
    }

    @Test
    fun formatDateSuccess() {
        val actual = formatDate("01-01-2024")
        val expected = "01 Jan 2024"
        assertEquals(expected, actual)
    }

    @Test
    fun formatDateUnknown() {
        val actual = formatDate(null)
        val expected = "Unknown"
        assertEquals(expected, actual)
    }

    @Test
    fun formatDateError() {
        val actual = formatDate("01/01/2024")
        val expected = "Date error"
        assertEquals(expected, actual)
    }
}