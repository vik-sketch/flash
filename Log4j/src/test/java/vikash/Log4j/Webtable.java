package vikash.Log4j;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;     // take one screenshot of table 

public class Webtable {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.seleniumeasy.com/test/table-sort-search-demo.html");
		
//1 How to get the table header ?	
		
		List<WebElement> header = driver.findElements(By.xpath("//table//thead/tr/th"));
		for (WebElement headerElement : header) {
			System.out.println(headerElement.getText());
		}
		System.out.println("*********************************************************************************************");	
		
//2 Count no of rows and column in a web table
		
		List<WebElement> allRows = driver.findElements(By.xpath("//tr"));
		int rows =allRows.size();
		
		List<WebElement> allColumns = driver.findElements(By.xpath("//th"));
		int column =allColumns.size();
		
		System.out.println("no of rows are "+rows +"  and no of column are "+column);
		System.out.println("**************************************************************************************************");
				
//3 Get value from particular column wrt given data (get the name of software engineer)
			
		for(int i =1;i<allRows.size();i++)
		{
			WebElement positionColumn = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[2]"));
			if(positionColumn.getText().equalsIgnoreCase("Software Engineer"))
			{
				WebElement name = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]"));
				System.out.println("name of the software engineers are = "+name.getText());
			}
		}		
		System.out.println("*******************************************************************************************************");
		
//4 Conditional (get all employees > 40 in age)
		
		for(int i =1;i<allRows.size();i++)
		{
			WebElement ageColumn = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[4]"));
			if(Integer.parseInt(ageColumn.getText())>40)
			{
				WebElement name = driver.findElement(By.xpath("//table/tbody/tr[" + i + "]/td[1]"));
				System.out.println("name of the software engineers are = "+name.getText());
			}
		}	
		System.out.println("*******************************************************************************************************");		
		
//5 How to Print last row in a web table		
		
		List<WebElement> lastRow = driver.findElements(By.xpath("//table//tbody//tr[last()]//td"));
		for (WebElement LastRowElement : lastRow) {
			System.out.println("element of last row are = "+LastRowElement.getText());
		}	
		System.out.println("*******************************************************************************************************");
		
//6 Get particular cell value  (i am trying to fetch data of 3rd row, 4th column i.e., 33 )
		
		WebElement threeFourth = driver.findElement(By.xpath("//table//tbody//tr[3]//td[4]"));
		
		System.out.println(threeFourth.getText());
		System.out.println("*******************************************************************************************************");

//7 Get particular cell value using custom method (done in another program )
		
//8 How to get all table data
		
		List<WebElement> allCellData = driver.findElements(By.xpath("//table//td"));
		for (WebElement alldata : allCellData) {
			System.out.print("all data that are present in the table are = "+alldata.getText()+" ");
		}
		System.out.println();
		System.out.println("*******************************************************************************************************");
		
//9 How to get particular column	(i am trying to get column no 3)	

	for(int i =1; i<allRows.size();i++) {	
		WebElement thirdColumn = driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]"));
		System.out.println("data of third column are = "+thirdColumn.getText());
	}
	System.out.println("*******************************************************************************************************");
	
//10 How to retrieve more than one column	(i am getting 1st,2nd,3rd column here)
		
		for(int i=1;i<allRows.size();i++) {
			for(int j=1;j<=3;j++)
			{
			    WebElement moreThanOneTable = driver.findElement(By.xpath("//table//tbody/tr["+i+"]/td["+j+"]"));
				System.out.print(moreThanOneTable.getText()+ " ");
			}
			System.out.println();
		}
		System.out.println("*******************************************************************************************************");		
	}
}
