package ru.geekbrains.main.site.at;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import ru.geekbrains.main.site.at.base.BeforeAndAfterStep;
import ru.geekbrains.main.site.at.block.SearchTabsBlock;
import ru.geekbrains.main.site.at.page.content.CoursePage;
import ru.geekbrains.main.site.at.page.content.SearchPage;
import ru.geekbrains.main.site.at.page.content.TestPage;


import static org.hamcrest.Matchers.*;

@Execution(ExecutionMode.CONCURRENT)
@DisplayName("Проверка работы Поиска")
public class SearchTest extends BeforeAndAfterStep {

    @DisplayName("Проверка Поиска")
    @Test
    void searchTest() {
        new TestPage(driver)
                .openUrl()
                .getHeader()
                .searchText("java")
                .getSearchTabsBlock()
                .checkCount(SearchTabsBlock.Tab.Professions,greaterThanOrEqualTo(2))
                .checkCount(SearchTabsBlock.Tab.Courses,greaterThan(15))
                .checkCount(SearchTabsBlock.Tab.Webinars,allOf(greaterThan(180), lessThan(300)))
                .checkCount(SearchTabsBlock.Tab.Blogs,greaterThan(300))
                .checkCount(SearchTabsBlock.Tab.Forums,not(350))
                .checkCount(SearchTabsBlock.Tab.Tests,not(0));
    }
}