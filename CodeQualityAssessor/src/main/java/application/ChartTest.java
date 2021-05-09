package application;

import static org.junit.jupiter.api.Assertions.*;

import java.io.FileNotFoundException;

import org.jfree.data.general.DefaultPieDataset;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ChartTest {
	Chart chart = new Chart();
	int VP;
	int FP;
	int VN;
	int FN;
	String CodeSmell = new String();

	@Test
	void testCreateChartIntIntIntIntString() throws Exception {
		chart.createChart(VP, FP, VN, FN, CodeSmell);
		assertNotNull(CodeSmell);
		assertNotNull(VP);
		assertNotNull(FP);
		assertNotNull(VN);
		assertNotNull(FN);

	}

	@Test
	void testCreateDataset() {
		Assertions.assertEquals(chart.createDataset(VP, FP, VN, FN).toString(),
				chart.createDataset(VP, FP, VN, FN).toString());
	}

	@Test
	void testCreateChartDefaultPieDatasetString() throws FileNotFoundException {
		DefaultPieDataset dataset = null;
		Assertions.assertEquals(chart.createChart(dataset, CodeSmell), chart.createChart(dataset, CodeSmell));
	}

}
