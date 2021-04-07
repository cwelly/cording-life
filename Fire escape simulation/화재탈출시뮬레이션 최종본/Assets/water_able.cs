using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class water_able : MonoBehaviour
{
    public GameObject cube;
    // Use this for initialization
    void Start()
    {

    }

    // Update is called once per frame
    void Update()
    {

    }
    void OnTriggerStay(Collider col)
    {
        if (col.tag == "Play")
        {

            if (Input.GetKeyDown(KeyCode.E))
            {
                cube.SetActive(true);
            }
        }
    }
}