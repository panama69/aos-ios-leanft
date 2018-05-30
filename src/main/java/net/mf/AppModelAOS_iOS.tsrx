<?xml version="1.0" encoding="utf-8" standalone="yes"?>
<applicationModel>
    <name>Application Model</name>
    <className>AppModelAOS_iOS</className>
    <objects>
        <object type="Application" technology="Mobile">
            <name>Advantage Shopping</name>
            <codeName>AOSApp</codeName>
            <description></description>
            <identification>
                <properties>
                    <property name="Identifier" type="string" isRegExp="false">com.mf.iShopping</property>
                    <property name="IsPackaged" type="boolean" isRegExp="false">true</property>
                </properties>
            </identification>
            <children>
                <object type="Button" technology="Mobile">
                    <name>Ok</name>
                    <codeName>OkButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">Ok</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                            <property name="Text" type="string" isRegExp="false">Ok</property>
                        </properties>
                    </identification>
                </object>
                <object type="EditField" technology="Mobile">
                    <name>Server URL</name>
                    <codeName>ServerURLEditField</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">Input</property>
                            <property name="Hint" type="string" isRegExp="false">Server URL</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>CONNECT</name>
                    <codeName>CONNECTButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">CONNECT</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                            <property name="Text" type="string" isRegExp="false">CONNECT</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>Menu</name>
                    <codeName>MenuButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">Menu</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">2</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>LOG IN</name>
                    <codeName>LOGINLabel</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">LOG IN</property>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="Container" type="string" isRegExp="false">Table[0][0][0]</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                            <property name="Text" type="string" isRegExp="false">LOG IN</property>
                        </properties>
                    </identification>
                </object>
                <object type="EditField" technology="Mobile">
                    <name>USER NAME</name>
                    <codeName>USERNAMEEditField</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">userNameLabel</property>
                            <property name="ClassName" type="string" isRegExp="false">Input</property>
                            <property name="Hint" type="string" isRegExp="false">USER NAME</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
                <object type="EditField" technology="Mobile">
                    <name>PASSWORD</name>
                    <codeName>PASSWORDEditField</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">passwordLabel</property>
                            <property name="ClassName" type="string" isRegExp="false">Input</property>
                            <property name="Hint" type="string" isRegExp="false">PASSWORD</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">1</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>LOGIN</name>
                    <codeName>LOGINButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">LOGIN</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">1</property>
                            <property name="Text" type="string" isRegExp="false">LOGIN</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>LAPTOPS</name>
                    <codeName>LAPTOPSLabel</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">LAPTOPS</property>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="Container" type="string" isRegExp="false">Table[0][0][0]</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                            <property name="Text" type="string" isRegExp="false">LAPTOPS</property>
                        </properties>
                    </identification>
                </object>
                <object type="UiObject" technology="Mobile">
                    <name>MobileObject</name>
                    <codeName>SelectedLaptop4</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">ImageView</property>
                            <property name="Container" type="string" isRegExp="false">CollectionView[0][3][0]</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>ADD TO CART</name>
                    <codeName>ADDTOCARTButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">ADD TO CART</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">4</property>
                            <property name="Text" type="string" isRegExp="false">ADD TO CART</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>Back</name>
                    <codeName>BackButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">Back</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">5</property>
                        </properties>
                    </identification>
                </object>
                <object type="UiObject" technology="Mobile">
                    <name>MobileObject1</name>
                    <codeName>OpenCart</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">ImageView</property>
                            <property name="Container" type="string" isRegExp="false">Table[0][8][0]</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>CHECKOUT (PAY 1,399.98)</name>
                    <codeName>CHECKOUTPAYButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">2</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>PAY NOW</name>
                    <codeName>PAYNOWButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">PAY NOW</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                            <property name="Text" type="string" isRegExp="false">PAY NOW</property>
                        </properties>
                    </identification>
                </object>
                <object type="Label" technology="Mobile">
                    <name>SIGN OUT</name>
                    <codeName>SIGNOUTLabel</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">SIGN OUT</property>
                            <property name="ClassName" type="string" isRegExp="false">Label</property>
                            <property name="Container" type="string" isRegExp="false">Table[0][0][0]</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">1</property>
                            <property name="Text" type="string" isRegExp="false">SIGN OUT</property>
                        </properties>
                    </identification>
                </object>
                <object type="Button" technology="Mobile">
                    <name>Yes</name>
                    <codeName>YesButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">Yes</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">0</property>
                            <property name="Text" type="string" isRegExp="false">Yes</property>
                        </properties>
                    </identification>
                </object>
            </children>
        </object>
        <object type="Application" technology="Mobile">
            <name>Home</name>
            <codeName>Home</codeName>
            <description></description>
            <identification>
                <properties>
                    <property name="Identifier" type="string" isRegExp="false">MC.Home</property>
                    <property name="IsPackaged" type="boolean" isRegExp="false">false</property>
                </properties>
            </identification>
            <children>
                <object type="Button" technology="Mobile">
                    <name>Allow</name>
                    <codeName>allowButton</codeName>
                    <description></description>
                    <identification>
                        <properties>
                            <property name="AccessibilityId" type="string" isRegExp="false">Allow</property>
                            <property name="ClassName" type="string" isRegExp="false">Button</property>
                            <property name="MobileCenterIndex" type="int" isRegExp="false">1</property>
                            <property name="Text" type="string" isRegExp="false">Allow</property>
                        </properties>
                    </identification>
                </object>
            </children>
        </object>
    </objects>
</applicationModel>
