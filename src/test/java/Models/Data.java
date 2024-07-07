package Models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
    private String dataColor;
    private String dataCapacity;
    private Long capacityGB;
    private Double dataPrice;
    private String dataGeneration;
    private Long year;
    private String cpuModel;
    private String hardDiskSize;
    private String strapColour;
    private String caseSize;
    private String color;
    private String description;
    private String capacity;
    private Double screenSize;
    private String generation;
    private String price;

    @JsonProperty("color")
    public String getDataColor() { return dataColor; }
    @JsonProperty("color")
    public void setDataColor(String value) { this.dataColor = value; }

    @JsonProperty("capacity")
    public String getDataCapacity() { return dataCapacity; }
    @JsonProperty("capacity")
    public void setDataCapacity(String value) { this.dataCapacity = value; }

    @JsonProperty("capacity GB")
    public Long getCapacityGB() { return capacityGB; }
    @JsonProperty("capacity GB")
    public void setCapacityGB(Long value) { this.capacityGB = value; }

    @JsonProperty("price")
    public Double getDataPrice() { return dataPrice; }
    @JsonProperty("price")
    public void setDataPrice(Double value) { this.dataPrice = value; }

    @JsonProperty("generation")
    public String getDataGeneration() { return dataGeneration; }
    @JsonProperty("generation")
    public void setDataGeneration(String value) { this.dataGeneration = value; }

    @JsonProperty("year")
    public Long getYear() { return year; }
    @JsonProperty("year")
    public void setYear(Long value) { this.year = value; }

    @JsonProperty("CPU model")
    public String getCPUModel() { return cpuModel; }
    @JsonProperty("CPU model")
    public void setCPUModel(String value) { this.cpuModel = value; }

    @JsonProperty("Hard disk size")
    public String getHardDiskSize() { return hardDiskSize; }
    @JsonProperty("Hard disk size")
    public void setHardDiskSize(String value) { this.hardDiskSize = value; }

    @JsonProperty("Strap Colour")
    public String getStrapColour() { return strapColour; }
    @JsonProperty("Strap Colour")
    public void setStrapColour(String value) { this.strapColour = value; }

    @JsonProperty("Case Size")
    public String getCaseSize() { return caseSize; }
    @JsonProperty("Case Size")
    public void setCaseSize(String value) { this.caseSize = value; }

    @JsonProperty("Color")
    public String getColor() { return color; }
    @JsonProperty("Color")
    public void setColor(String value) { this.color = value; }

    @JsonProperty("Description")
    public String getDescription() { return description; }
    @JsonProperty("Description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("Capacity")
    public String getCapacity() { return capacity; }
    @JsonProperty("Capacity")
    public void setCapacity(String value) { this.capacity = value; }

    @JsonProperty("Screen size")
    public Double getScreenSize() { return screenSize; }
    @JsonProperty("Screen size")
    public void setScreenSize(Double value) { this.screenSize = value; }

    @JsonProperty("Generation")
    public String getGeneration() { return generation; }
    @JsonProperty("Generation")
    public void setGeneration(String value) { this.generation = value; }

    @JsonProperty("Price")
    public String getPrice() { return price; }
    @JsonProperty("Price")
    public void setPrice(String value) { this.price = value; }
}