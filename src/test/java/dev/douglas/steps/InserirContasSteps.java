package dev.douglas.steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import io.cucumber.core.api.Scenario;

public class InserirContasSteps {
	private WebDriver driver;
	
	@Dado("^que estou acessando a aplicação$")
	public void queEstouAcessandoAAplicação() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://seubarriga.wcaquino.me/login");
		driver.manage().window().maximize();		
	}

	@Quando("^informo o usuário \"([^\"]*)\"$")
	public void informoOUsuário(String arg1) throws Throwable {
	    WebElement emailAddressElement = driver.findElement(By.xpath("//*[@id=\"email\"]"));
	    emailAddressElement.sendKeys(arg1);
	}

	@Quando("^a senha \"([^\"]*)\"$")
	public void aSenha(String arg1) throws Throwable {
	    WebElement passwordElement = driver.findElement(By.xpath("//*[@id=\"senha\"]"));
	    passwordElement.sendKeys(arg1);
	}

	@Quando("^seleciono entrar$")
	public void selecionoEntrar() throws Throwable {
	    WebElement submitBtnElement = driver.findElement(By.xpath("/html/body/div[2]/form/button"));
	    submitBtnElement.click();
	}

	@Então("^visualizo a página inicial$")
	public void visualizoAPáginaInicial() throws Throwable {
	    WebElement messageWelcomeElement = driver.findElement(By.xpath("/html/body/div[1]"));
	    String messageWelcome = messageWelcomeElement.getText();
	    
	    Assert.assertTrue(messageWelcome.equals("Bem vindo, Douglas!"));
	}

	@Quando("^seleciono Contas$")
	public void selecionoContas() throws Throwable {
		WebElement selectContaBtnElement = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/a"));
		selectContaBtnElement.click();
	}

	@Quando("^seleciono Adicionar$")
	public void selecionoAdicionar() throws Throwable {
		WebElement selectAdicionarBtnElement = driver.findElement(By.xpath("//*[@id=\"navbar\"]/ul/li[2]/ul/li[1]/a"));
		selectAdicionarBtnElement.click();
	}

	@Quando("^informo a conta \"([^\"]*)\"$")
	public void informoAConta(String arg1) throws Throwable {
	    WebElement contaElement = driver.findElement(By.xpath("//*[@id=\"nome\"]"));
	    contaElement.sendKeys(arg1);
	}

	@Quando("^seleciono Salvar$")
	public void selecionoSalvar() throws Throwable {
		WebElement submitSalvarBtnElement = driver.findElement(By.xpath("/html/body/div[2]/form/div[2]/button"));
		submitSalvarBtnElement.click();
	}
	
	@Então("^recebo a mensagem \"([^\"]*)\"$")
	public void receboAMensagem(String arg1) throws Throwable {
		WebElement messageElement = driver.findElement(By.xpath("/html/body/div[1]"));
	    String message = messageElement.getText();
	    
	    Assert.assertEquals(arg1, message);
	}	
	
	@After(order = 1, value = "@funcionais")
	public void screenshot(Scenario cenario) {		
		File SrcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
			
		try {
			FileUtils.copyFile(SrcFile, new File("target//screenshot//"+cenario.getId()+".png"));
	    } catch (IOException e) {
	        System.out.println(e.getMessage());
	    }
	}
	
	@After(order = 0, value = "@funcionais")
		public void fecharBrowser() {
			driver.quit();
		}
	}
