package de.telran;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(PositiveTestCategory.class)

@Suite.SuiteClasses({
        TrackingServiceTest.class})

public class CategoryTestSuite {
}
