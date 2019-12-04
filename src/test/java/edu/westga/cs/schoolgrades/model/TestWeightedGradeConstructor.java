package edu.westga.cs.schoolgrades.model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class TestWeightedGradeConstructor {

	@Test
	public void shouldNotAllowNullGrade() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			new WeightedGrade(null, 10.0);
		});
	}
	
	@Test
	public void shouldNotAllowNegativeWeight() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			new WeightedGrade(mock(Grade.class), -10.0);
		});
	}
	
	@Test
	public void shouldNotAllowWeightGreaterThanOne() {
		assertThrows(IllegalArgumentException.class, () ->{ 
			new WeightedGrade(mock(Grade.class), 10.0);
		});
	}
}
