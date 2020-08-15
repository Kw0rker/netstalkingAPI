package parsers.validators;

import network.utils;

import java.util.List;

public class imgurValidator implements validator {

    public String validate(String link) {
        String redirect=utils.getRedirect(link);
        if (redirect==null)return link;
        return "";
    }

    public List<String> validate(List<String> links) {
        return null;
    }
}
