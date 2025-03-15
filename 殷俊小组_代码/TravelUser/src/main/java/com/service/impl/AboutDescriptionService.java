package com.service.impl;

import com.controller.AboutDescriptionDao;

public class AboutDescriptionService {
    static AboutDescriptionDao aboutDescriptionDao = new AboutDescriptionDao();
    public static String getAboutDescription() {
        return aboutDescriptionDao.getAboutDescription();
    }
}
