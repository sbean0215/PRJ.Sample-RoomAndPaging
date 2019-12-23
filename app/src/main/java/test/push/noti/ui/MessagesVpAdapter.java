package test.push.noti.ui;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import test.push.noti.base.BaseFragment;

import java.util.ArrayList;

public class MessagesVpAdapter extends FragmentStatePagerAdapter {

    private ArrayList<BaseFragment> fragments;

    public MessagesVpAdapter(FragmentManager fm){
        super(fm);

        fragments = new ArrayList<>();

        fragments.add(MsgAdFragment.newInstance());   //page 0
        fragments.add(MsgNoticeFragment.newInstance());
        fragments.add(MsgMessagesFragment.newInstance());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }


    public BaseFragment getItem(Class fragmentClass) {
        if (fragmentClass.isAssignableFrom(MsgAdFragment.class))             return fragments.get(0);
        else if (fragmentClass.isAssignableFrom(MsgNoticeFragment.class))    return fragments.get(1);
        else if (fragmentClass.isAssignableFrom(MsgMessagesFragment.class))  return fragments.get(2);

        return null;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragments.get(position).getTitle();
    }
}
