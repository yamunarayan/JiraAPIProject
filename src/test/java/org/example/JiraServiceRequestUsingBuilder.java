package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@Builder(toBuilder=true)

public class JiraServiceRequestUsingBuilder {
    private Fields fields;
    @Builder(toBuilder=true)
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
        @Builder(toBuilder=true)
        @Data
        public static class Project {

            @JsonProperty("key")
            private String key;

        }
        @Builder(toBuilder=true)
        @Data
        public static class Issuetype {

            @JsonProperty("name")
            private String name;

        }
        @Builder(toBuilder=true)
        @Data
        public static class Description {

            @JsonProperty("type")
            private String type;
            @JsonProperty("version")
            private Integer version;
            @JsonProperty("content")
            private List<Content> content = null;
            @Builder(toBuilder=true)
            @Data
            public static class Content {

                @JsonProperty("type")
                private String type;
                @JsonProperty("content")
                private List<Content__1> content = null;
                @Builder(toBuilder=true)
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