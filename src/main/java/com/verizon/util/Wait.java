package com.verizon.util;

import org.openqa.selenium.WebElement;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;


/**
 * Created by vjean on 8/18/2017.
 */
public class Wait {

    public void untilElementIsOnScreen(WebElement element) {
        final int TIME_LIMIT = 60;
        for (int counter = 0; isElementNotOnScreen(element) && counter < TIME_LIMIT; counter++) {
            setSecondsToWait(1);
            printWaitingMessage(counter);
        }
    }

    public void untilElementIsClickable(WebElement element) {
        final int TIME_LIMIT = 60;
        for (int counter = 0; isElementNotOnScreen(element) && counter < TIME_LIMIT; counter++) {
            setSecondsToWait(1);
            printWaitingMessage(counter);
        }
    }

    private boolean isElementNotOnScreen(WebElement element) {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                return false;
            }
        } catch (NoSuchElementException ignored) {}

        return true;
    }

    public void setSecondsToWait(int seconds) {
        try {
            TimeUnit.SECONDS.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printWaitingMessage(int counter) {
        if (counter == 2) {
            System.out.print("\n> Waiting until element is visible..");
        } else if (counter > 2) {
            System.out.print(".");
        }
    }
}
