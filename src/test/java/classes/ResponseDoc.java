package classes;

public class ResponseDoc {
    private Response response;
    public class Response{
        private String type;
        private Doc doc;
        public class Doc {
            private int id;
            private int owner_id;
            private String title;
            private int size;
            private String ext;
            private int date;
            private int type;
            private String url;
            private Preview preview;

            public class Preview {
                private Photo photo;
                public class Photo {
                    private Size[] sizes;
                    public class Size {
                        private String src;
                        private int width;
                        private int height;
                        private String type;
                    }
                }
            }
        }
    }

    public String getType(){
        return this.response.type;
    }

    public int getId(){
        return this.response.doc.id;
    }

    public int getOwnerId(){
        return this.response.doc.owner_id;
    }
}
