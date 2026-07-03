# 📱 Practice Android — JSON Parsing using Volley & Glide

এটি একটি প্রফেশনাল অ্যান্ড্রয়েড প্রজেক্ট যেখানে লোকালহোস্ট সার্ভার (XAMPP) থেকে ভলি (Volley) লাইব্রেরি ব্যবহার করে নেস্টেড (Nested) JSON ডেটা সফলভাবে পার্স করা হয়েছে। অ্যাপটিতে একটি কাস্টম `ListView` এবং `CardView` ব্যবহার করে অভিনেত্রীদের প্রোফাইল, বায়োগ্রাফি এবং কন্টাক্ট ইনফরমেশন প্রদর্শন করা হয়েছে।

---

## 🚀 বৈশিষ্ট্যসমূহ (Features)
- **Volley Networking:** সার্ভার থেকে অ্যাসিনক্রোনাসলি JSON অ্যারে এবং সাব-অবজেক্ট ডেটা ফেচ করা।
- **Glide Image Loading:** নেটওয়ার্ক ইমেজগুলোকে ক্যাশিং সুবিধাসহ স্মুথলি লোড করা।
- **Nested JSON Parsing:** একটি মেইন অবজেক্টের ভেতর থাকা সাব-অবজেক্ট (`ContactDataHouse`) থেকে ফোন ও ইমেইল সফলভাবে রিড করা।
- **Custom BaseAdapter:** লিস্টভিউ আইটেমগুলোকে কাস্টম লেআউটে সাজানোর জন্য দক্ষ অ্যাডাপ্টার ইমপ্লিমেন্টেশন।
- **Explicit Intent Data Passing:** মেইন স্ক্রিনের কোনো আইটেমে ক্লিক করলে সম্পূর্ণ ডেটা দ্বিতীয় অ্যাক্টিভিটিতে (`MainActivity2`) পুশ করা।

---

## 🛠️ টেকনোলজি স্ট্যাক (Tech Stack)
- **Language:** Java (Android SDK)
- **UI Architecture:** `LinearLayout`, `CardView`, `NestedScrollView`
- **Libraries:** - [Volley](https://github.com/google/volley) (Networking)
  - [Glide](https://github.com/bumptech/glide) (Image Loading)

---

## 📂 JSON ডেটা স্ট্রাকচার (`actresstwo.json`)
অ্যাপটি রান করার জন্য আপনার সার্ভারে নিচের ফরম্যাটে JSON ফাইলটি থাকতে হবে:

```json
[
  {
    "ImageDataHouse": "[http://192.168.0.107/practiceandroid/images/actress1.jpg](http://192.168.0.107/practiceandroid/images/actress1.jpg)",
    "TitleDataHouse": "Actress Name Here",
    "DescriptionDataHouse": "Full biography or description text goes here...",
    "ContactDataHouse": {
      "PhoneContactHouse": "+88017XXXXXXXX",
      "EmailContactHouse": "actress@example.com"
    }
  }
]








[
{
  "ImageDataHouse": "https://i.pinimg.com/1200x/7a/56/6d/7a566db528e5988bca1c2f5c506b27c2.jpg",
  "TitleDataHouse": "Sanam Baloch",
  "DescriptionDataHouse": "Sanam Baloch is a former Pakistani actress and television host who became famous through hit dramas such as Dastaan and Kankar. Her natural acting and warm personality made her one of the most admired celebrities in Pakistan.",
  "ContactDataHouse": {
    "PhoneContactHouse": "+92-310-1112287",
    "EmailContactHouse": "sanam.baloch@example.com"
  }
}
]
