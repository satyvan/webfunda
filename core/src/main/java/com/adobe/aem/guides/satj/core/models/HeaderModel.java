package com.adobe.aem.guides.satj.core.models;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;
import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class HeaderModel {
    @Inject
    private ResourceResolver resolver;
    PageManager page ;
       // current page

    public List<Page> getChildPages() {
        List<Page> pages = new ArrayList<>();
       Resource currentResourceData = resolver.getResource("/content/satj/us/en");  // current page
        //page = resolver.adaptTo().ge
        if (currentResourceData != null) {
            for (Iterator<Resource> it = currentResourceData.listChildren(); it.hasNext(); ) {
                Resource childPage = it.next();
                pages.add(childPage);
            }
        }
        return pages;
    }

//    public List<Page> getChildPages() {
//        List<Page> childPages = new ArrayList<>();
//        Resource parent = resolver.getResource("/content/satj/us/en");
//
//        if (parent != null) {
//            for (Resource child : parent.getChildren()) {
//                if (child.getValueMap().containsKey("jcr:primaryType") &&
//                        "cq:Page".equals(child.getValueMap().get("jcr:primaryType"))) {
//                    childPages.add(child.adaptTo(Page.class));
//                    PageManager pageManager = resolver.adaptTo(PageManager.class);
//                        String currentPagePath = Optional.ofNullable(pageManager)
//                                .map(pm -> pm.getContainingPage(child))
//                                .map(Page::getPath).orElse("");
//                    System.out.println("Child Page: " + child.getName() + " Path: " + currentPagePath);
//
//                }
//            }
//        }
//        return childPages;
//    }
//}

}