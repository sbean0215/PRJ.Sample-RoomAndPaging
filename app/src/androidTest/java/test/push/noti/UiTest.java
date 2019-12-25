package test.push.noti;

import androidx.test.espresso.intent.Intents;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import test.push.noti.ui.addnew.AddNewUserActivity;
import test.push.noti.ui.entrance.EntranceActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.*;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@LargeTest
public class UiTest {

    @Rule
    public ActivityTestRule<EntranceActivity> activityRule = new ActivityTestRule<>(EntranceActivity.class);

    @Before
    public void initBeforeOpenActivityTest() {
        Intents.init();     //for intended(hasComponent((~
    }

    /* 새로운 유저추가 버튼 클릭시 정상적으로 AddNewUserActivity 열리는지 확인*/
    @Test
    public void testOpenAddNewUserTest() {
        onView(withText(R.string.entrance_user_add))
                .perform(click());

        intended(hasComponent(AddNewUserActivity.class.getName()));
    }

    @Test
    public void addNewUser() {
        testOpenAddNewUserTest();

        onView(withId(R.id.et_user_name))
                .perform(typeText("Sung Bean"), closeSoftKeyboard());

        onView(withId(R.id.btn_add_new_user))
                .perform(click());

    }

}
