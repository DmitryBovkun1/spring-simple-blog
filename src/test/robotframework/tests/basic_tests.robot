*** Settings ***
Library    Selenium2Library
#Library    SeleniumKeywords

*** Variables ***
${BROWSER}        Chrome
${BASE_URL}       http://localhost:8080/

*** Test Cases ***

Login Test
    Open Browser    ${BASE_URL}    ${BROWSER}
    Set Window Size    1936    1056
    Mouse Over    link=Login
    Click Element    link=Login
    Input Text    id=username    test
    Input Password    id=password    2203
    Press Keys    id=password    ENTER
    Click Element    css=.card-panel
    Double Click Element    css=.card-panel
    Input Text    id=username    test
    Input Password    id=password    2202
    Press Keys    id=password    ENTER
    Click Element    id=logout-mobile
    Click Element    css=.alert
    Click Element    css=.container:nth-child(3)
    Close Browser

Post and Comment Function Test
    [Documentation]    Test post and comment functionality
    Open Browser    ${BASE_URL}    ${BROWSER}
	Set Window Size    757    1020    
	Wait Until Element Is Visible    css=.button-collapse > .material-icons
    Click Element    css=.button-collapse > .material-icons
    Wait Until Element Is Visible    link=Login
    Click Element    link=Login
    Input Text    id=username    test
    Input Text    id=password    2202
    Press Keys    id=password    ENTER
    Wait Until Element Is Visible    css=.button-collapse > .material-icons
    Click Element    css=.button-collapse > .material-icons
    Wait Until Element Is Visible    link=Create a post
    Click Element    link=Create a post
    Input Text    id=title    test
    Input Text    id=body    testtesttesttesttest
    Click Element    css=.select-wrapper
	Execute JavaScript    document.querySelector('.select-dropdown').click()
    Click Element    css=li:nth-child(2) > span
    Click Element    css=li:nth-child(4) > span
    Click Element    css=li:nth-child(5) > span
    Execute JavaScript    document.getElementById('create-btn').click()
    Click Element    css=.card:nth-child(1) .material-icons
    Click Element    id=newComment
    Input Text    id=newComment    test comment
    Click Element    css=.input-field > .waves-effect
    Click Element    css=.collection-item > p
    Double Click Element    css=.collection-item > p
    Click Element    css=.container:nth-child(3) > .row
    Click Element    css=.deep-orange > .material-icons
    Close Browser

Edit User Test
    [Documentation]    Test editing user functionality
    Open Browser    ${BASE_URL}    ${BROWSER}
    Maximize Browser Window
    Wait Until Element Is Visible    link=Login
    Click Element    link=Login
    Input Text    id=username    test
    Input Text    id=password    2202
    Press Keys    id=password    ENTER
    Wait Until Element Is Visible    css=#nav-mobile .waves-effect > .navbar-text
    Click Element    css=#nav-mobile .waves-effect > .navbar-text
    Wait Until Element Is Visible    css=.btn-floating > .material-icons
    Click Element    css=.btn-floating > .material-icons
    Input Text    id=password    2203
    Press Keys    id=password    ENTER
    Wait Until Element Is Visible    id=logout-mobile
    Click Element    id=logout-mobile
    Input Text    id=username    test
    Wait Until Element Is Visible    css=.alert
    Click Element    css=.alert
    Click Element    css=.alert
    Double Click Element    css=.alert
    Click Element    css=.alert
    Input Text    id=username    test
    Input Text    id=password    2203
    Press Keys    id=password    ENTER
    Wait Until Element Is Visible    link=Welcome test!
    Click Element    link=Welcome test!
    Wait Until Element Is Visible    css=.btn-floating > .material-icons
    Click Element    css=.btn-floating > .material-icons
    Input Text    id=password    2202
    Press Keys    id=password    ENTER
    Wait Until Element Is Visible    id=logout-mobile
    Click Element    id=logout-mobile
    Close Browser
