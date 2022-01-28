package com.automatedtest.sample;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = {"src/test/resources/com/automatedtest/sample/videoConference.feature"},
        strict = false, plugin = {"pretty",
        "json:target/cucumber_json_reports/videoconf.json",
        "html:target/videoconf-html"},
        glue = {"com.automatedtest.sample.infrastructure.driver",
                "com.automatedtest.sample.homepage",
                "com.automatedtest.sample.videoconf"})
public class videoConf {
}
