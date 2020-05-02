package ru.geekbrains.main.site.at.page.content;

import org.openqa.selenium.WebDriver;
import ru.geekbrains.main.site.at.block.SearchTabsBlock;
import ru.geekbrains.main.site.at.page.OpenUrl;

public class SearchPage extends ContentBasePage implements OpenUrl {

    private SearchTabsBlock searchTabsBlock;

    public SearchPage(WebDriver driver) {
        super(driver);
        this.searchTabsBlock = new SearchTabsBlock(driver);
    }

    @Override
    public SearchPage openUrl() {
        driver.get("https://geekbrains.ru/search");
        return this;
    }

    public SearchTabsBlock getSearchTabsBlock() {
        return searchTabsBlock;
    }
}
