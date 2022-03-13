from rest_framework import serializers
from poultryfarm.models import Temperature, Humidity, Ammonia, Dioxide



class TemperatureSerializer(serializers.ModelSerializer):
    class Meta:
        model = Temperature
        fields = '__all__'


class HumiditySerializer(serializers.ModelSerializer):
    class Meta:
        model = Humidity
        fields = '__all__'


class AmmoniaSerializer(serializers.ModelSerializer):
    class Meta:
        model = Ammonia
        fields = '__all__'


class DioxideSerializer(serializers.ModelSerializer):
    class Meta:
        model = Dioxide
        fields = '__all__'


