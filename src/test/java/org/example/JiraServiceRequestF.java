package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.testng.annotations.DataProvider;

import java.util.List;
@Data

public class JiraServiceRequestF {
    private Fields fields;
    @Data
    public static class Fields {

        @JsonProperty("project")
        private Project project;
        @JsonProperty("summary")
        private String summary;
        @JsonProperty("issuetype")
        private Issuetype issuetype;
        @JsonProperty("description")
        private Description description;
        @Data
        public static class Project {

            @JsonProperty("key")
            private String key;

        }
        @Data
        public static class Issuetype {

            @JsonProperty("name")
            private String name;

        }
        @Data
        public static class Description {

            @JsonProperty("type")
            private String type;
            @JsonProperty("version")
            private Integer version;
            @JsonProperty("content")
            private List<Content> content = null;
            @Data
            public static class Content {

                @JsonProperty("type")
                private String type;
                @JsonProperty("content")
                private List<Content__1> content = null;
                @Data
                public static class Content__1 {

                    @JsonProperty("text")
                    private String text;
                    @JsonProperty("type")
                    private String type;

                }

            }

        }

    }

}