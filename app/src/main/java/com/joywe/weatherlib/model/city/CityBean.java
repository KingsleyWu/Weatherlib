package com.joywe.weatherlib.model.city;

import java.util.List;

/**
 * cities 用于提取Cities.json数据
 * @author 吴文成
 */
public class CityBean {


    /**
     * name : 广东
     * townId : CHBJ000000
     * areaId : 101010100
     * area : [{"name":"广州","townId":"CHGD000000","areaId":"101280101","area":[{"name":"番禺区","townId":"CHGD000100","areaId":"101280101"},{"name":"花都区","townId":"CHGD000400"},{"name":"南沙区"},{"name":"萝岗区"},{"name":"增城市","townId":"CHGD000300"},{"name":"从化市","townId":"CHGD000200"}]},{"name":"深圳","townId":"CHGD050000","areaId":"101280601","area":[{"name":"福田区"},{"name":"罗湖区"},{"name":"南山区"},{"name":"宝安区"},{"name":"龙岗区"},{"name":"盐田区"}]},{"name":"珠海","townId":"CHGD060000","areaId":"101280701","area":[{"name":"香洲区"},{"name":"斗门区","townId":"CHGD060100"},{"name":"金湾区","townId":"CHGD060200"}]},{"name":"汕头","townId":"CHGD040000","areaId":"101280501","area":[{"name":"金平区"},{"name":"濠江区"},{"name":"龙湖区"},{"name":"潮阳区","townId":"CHGD040100"},{"name":"潮南区"},{"name":"澄海区","townId":"CHGD040200"},{"name":"南澳县","townId":"CHGD040300"}]},{"name":"韶关","townId":"CHGD010000","areaId":"101280201","area":[{"name":"浈江区","townId":"CHGD010900"},{"name":"武江区","townId":"CHGD011000"},{"name":"曲江区","townId":"CHGD010800"},{"name":"乐昌市","townId":"CHGD010400"},{"name":"南雄市","townId":"CHGD010600"},{"name":"始兴县","townId":"CHGD010200"},{"name":"仁化县","townId":"CHGD010500"},{"name":"翁源县","townId":"CHGD010300"},{"name":"新丰县","townId":"CHGD010700"},{"name":"乳源瑶族自治县","townId":"CHGD010100"}]},{"name":"佛山","townId":"CHGD070000","areaId":"101280800","area":[{"name":"禅城区"},{"name":"南海区","townId":"CHGD070300"},{"name":"顺德区","townId":"CHGD070100"},{"name":"三水区","townId":"CHGD070200"},{"name":"高明区","townId":"CHGD070400"}]},{"name":"江门","townId":"CHGD100000","areaId":"101281101","area":[{"name":"蓬江区","townId":"CHGD100500"},{"name":"江海区","townId":"CHGD100700"},{"name":"新会区","townId":"CHGD100200"},{"name":"恩平市","townId":"CHGD100300"},{"name":"台山市","townId":"CHGD100400"},{"name":"开平市","townId":"CHGD100100"},{"name":"鹤山市","townId":"CHGD100600"}]},{"name":"湛江","townId":"CHGD090000","areaId":"101281001","area":[{"name":"赤坎区","townId":"CHGD090500"},{"name":"霞山区","townId":"CHGD090800"},{"name":"坡头区","townId":"CHGD090700"},{"name":"麻章区","townId":"CHGD090900"},{"name":"吴川市","townId":"CHGD090100"},{"name":"廉江市","townId":"CHGD090400"},{"name":"雷州市","townId":"CHGD090200"},{"name":"遂溪县","townId":"CHGD090600"},{"name":"徐闻县","townId":"CHGD090300"}]},{"name":"茂名","townId":"CHGD190000","areaId":"101282001","area":[{"name":"茂南区"},{"name":"茂港区","townId":"CHGD190500"},{"name":"化州市","townId":"CHGD190200"},{"name":"信宜市","townId":"CHGD190400"},{"name":"高州市","townId":"CHGD190100"},{"name":"电白县","townId":"CHGD190300"}]},{"name":"肇庆","townId":"CHGD080000","areaId":"101280901","area":[{"name":"端州区"},{"name":"鼎湖区"},{"name":"高要市","townId":"CHGD080600"},{"name":"四会市","townId":"CHGD080200"},{"name":"广宁县","townId":"CHGD080100"},{"name":"怀集县","townId":"CHGD080400"},{"name":"封开县","townId":"CHGD080500"},{"name":"德庆县","townId":"CHGD080300"}]},{"name":"惠州","townId":"CHGD020000","areaId":"101280301","area":[{"name":"惠城区"},{"name":"惠阳区","townId":"CHGD020200"},{"name":"博罗县","townId":"CHGD020100"},{"name":"惠东县","townId":"CHGD020300"},{"name":"龙门县","townId":"CHGD020400"}]},{"name":"梅州","townId":"CHGD030000","areaId":"101280401","area":[{"name":"梅江区"},{"name":"兴宁市","townId":"CHGD030100"},{"name":"梅县","townId":"CHGD030700"},{"name":"大埔县","townId":"CHGD030300"},{"name":"丰顺县","townId":"CHGD030400"},{"name":"五华县","townId":"CHGD030600"},{"name":"平远县","townId":"CHGD030500"},{"name":"蕉岭县","townId":"CHGD030200"}]},{"name":"汕尾","townId":"CHGD200000","areaId":"101282101","area":[{"name":"城区"},{"name":"陆丰市","townId":"CHGD200200"},{"name":"海丰县","townId":"CHGD200100"},{"name":"陆河县","townId":"CHGD200300"}]},{"name":"河源","townId":"CHGD110000","areaId":"101281201","area":[{"name":"源城区"},{"name":"紫金县","townId":"CHGD110100"},{"name":"龙川县","townId":"CHGD110400"},{"name":"连平县","townId":"CHGD110200"},{"name":"和平县","townId":"CHGD110300"},{"name":"东源县","townId":"CHGD110500"}]},{"name":"阳江","townId":"CHGD170000","areaId":"101281801","area":[{"name":"江城区"},{"name":"阳春市","townId":"CHGD170100"},{"name":"阳西县","townId":"CHGD170300"},{"name":"阳东县","townId":"CHGD170200"}]},{"name":"清远","townId":"CHGD120000","areaId":"101281301","area":[{"name":"清城区"},{"name":"英德市","townId":"CHGD120600"},{"name":"连州市","townId":"CHGD120200"},{"name":"佛冈县","townId":"CHGD120500"},{"name":"阳山县","townId":"CHGD120400"},{"name":"清新县","townId":"CHGD120700"},{"name":"连山壮族瑶族自治县","townId":"CHGD120300"},{"name":"连南瑶族自治县","townId":"CHGD120100"}]},{"name":"东莞","townId":"CHGD150000","areaId":"101281601"},{"name":"中山","townId":"CHGD160000","areaId":"101281701"},{"name":"潮州","townId":"CHGD140000","areaId":"101281501","area":[{"name":"湘桥区"},{"name":"潮安县","townId":"CHGD140200"},{"name":"饶平县","townId":"CHGD140100"}]},{"name":"揭阳","townId":"CHGD180000","areaId":"101281901","area":[{"name":"榕城区"},{"name":"普宁市","townId":"CHGD180200"},{"name":"揭东县","townId":"CHGD180400"},{"name":"揭西县","townId":"CHGD180100"},{"name":"惠来县","townId":"CHGD180300"}]},{"name":"云浮","townId":"CHGD130000","areaId":"101281401","area":[{"name":"云城区"},{"name":"罗定市","townId":"CHGD130100"},{"name":"云安县","townId":"CHGD130400"},{"name":"新兴县","townId":"CHGD130200"},{"name":"郁南县","townId":"CHGD130300"}]}]
     */

    private String name;
    private String townId;
    private String areaId;
    private List<Area> area;

    @Override
    public String toString() {
        return "CityBean{" +
                "name='" + name + '\'' +
                ", townId='" + townId + '\'' +
                ", areaId='" + areaId + '\'' +
                ", area=" + area +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTownId(String townId) {
        this.townId = townId;
    }

    public void setAreaId(String areaId) {
        this.areaId = areaId;
    }

    public void setArea(List<Area> area) {
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public String getTownId() {
        return townId;
    }

    public String getAreaId() {
        return areaId;
    }

    public List<Area> getArea() {
        return area;
    }

    public static class Area {
        /**
         * name : 广州
         * townId : CHGD000000
         * areaId : 101280101
         * area : [{"name":"番禺区","townId":"CHGD000100","areaId":"101280101"},{"name":"花都区","townId":"CHGD000400"},{"name":"南沙区"},{"name":"萝岗区"},{"name":"增城市","townId":"CHGD000300"},{"name":"从化市","townId":"CHGD000200"}]
         */

        private String name;
        private String townId;
        private String areaId;
        private List<InnerArea> area;

        @Override
        public String toString() {
            return "Area{" +
                    "name='" + name + '\'' +
                    ", townId='" + townId + '\'' +
                    ", areaId='" + areaId + '\'' +
                    ", area=" + area +
                    '}';
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setTownId(String townId) {
            this.townId = townId;
        }

        public void setAreaId(String areaId) {
            this.areaId = areaId;
        }

        public void setArea(List<InnerArea> area) {
            this.area = area;
        }

        public String getName() {
            return name;
        }

        public String getTownId() {
            return townId;
        }

        public String getAreaId() {
            return areaId;
        }

        public List<InnerArea> getArea() {
            return area;
        }

        public static class InnerArea {
            /**
             * name : 番禺区
             * townId : CHGD000100
             * areaId : 101280101
             */

            private String name;
            private String townId;
            private String areaId;

            @Override
            public String toString() {
                return "InnerArea{" +
                        "name='" + name + '\'' +
                        ", townId='" + townId + '\'' +
                        ", areaId='" + areaId + '\'' +
                        '}';
            }

            public void setName(String name) {
                this.name = name;
            }

            public void setTownId(String townId) {
                this.townId = townId;
            }

            public void setAreaId(String areaId) {
                this.areaId = areaId;
            }

            public String getName() {
                return name;
            }

            public String getTownId() {
                return townId;
            }

            public String getAreaId() {
                return areaId;
            }
        }
    }
}
