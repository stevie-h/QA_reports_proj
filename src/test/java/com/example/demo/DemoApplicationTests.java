package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests
{

	@Test
	void contextLoads()
	{
	}


	@Test
	public void test_HighwayLegalSpeed_pos()
	{
		Utils utils = new Utils();
		assertEquals(true, utils.checkHighwayLegalSpeed(ReportTestData.highway_legal_speed));
	}

	@Test
	public void test_HighwayLegalSpeed_neg()
	{
		Utils utils = new Utils();
		assertEquals(false, utils.checkHighwayLegalSpeed(ReportTestData.highway_illegal_speed));
	}

	@Test
	public void test_UrbanLegalSpeed_pos()
	{
		Utils utils = new Utils();
		assertEquals(true, utils.checkUrbanLegalSpeed(ReportTestData.urban_legal_speed));
	}

	@Test
	public void test_UrbanLegalSpeed_neg()
	{
		Utils utils = new Utils();
		assertEquals(false, utils.checkUrbanLegalSpeed(ReportTestData.urban_illegal_speed));
	}


}
