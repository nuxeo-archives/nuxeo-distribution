/*
 * (C) Copyright 2011 Nuxeo SA (http://nuxeo.com/) and contributors.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser General Public License
 * (LGPL) version 2.1 which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/lgpl.html
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * Contributors:
 *     Benoit Delbosc
 *     Antoine Taillefer
 */
package org.nuxeo.functionaltests.pages.admincenter.usermanagement;

import static org.junit.Assert.assertEquals;

import org.nuxeo.functionaltests.Required;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * View user details (New one in the admin center)
 *
 * @since 5.4.2
 */
public class UserViewTabSubPage extends UsersGroupsBasePage {

    @Required
    @FindBy(linkText = "View")
    WebElement viewUserTab;

    @FindBy(linkText = "Delete")
    WebElement deleteUserLink;

    @FindBy(linkText = "Edit")
    WebElement editLink;

    @FindBy(linkText = "Change password")
    WebElement changePasswordLink;

    public UserViewTabSubPage(WebDriver driver) {
        super(driver);
    }

    public UsersTabSubPage deleteUser() {
        deleteUserLink.click();
        Alert alert = driver.switchTo().alert();
        assertEquals("Delete user?", alert.getText());
        alert.accept();
        return asPage(UsersTabSubPage.class);
    }

    public UserEditFormPage getEditUserTab() {
        editLink.click();
        return asPage(UserEditFormPage.class);
    }

    public UserChangePasswordFormPage getChangePasswordUserTab() {
        changePasswordLink.click();
        return asPage(UserChangePasswordFormPage.class);
    }

    public UsersTabSubPage backToTheList() {
        findElementWithTimeout(By.linkText("Back to the list")).click();
        return asPage(UsersTabSubPage.class);
    }

}
